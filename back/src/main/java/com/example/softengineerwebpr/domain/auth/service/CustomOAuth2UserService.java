package com.example.softengineerwebpr.domain.auth.service;

import com.example.softengineerwebpr.common.util.UserCodeGenerator;
import com.example.softengineerwebpr.domain.auth.dto.OAuthAttributes;
import com.example.softengineerwebpr.domain.auth.entity.OAuthProvider;
import com.example.softengineerwebpr.domain.auth.entity.UserOAuthConnection;
import com.example.softengineerwebpr.domain.auth.repository.OAuthProviderRepository;
import com.example.softengineerwebpr.domain.auth.repository.UserOAuthConnectionRepository;
import com.example.softengineerwebpr.domain.user.entity.User;
import com.example.softengineerwebpr.domain.user.repository.UserRepository;
import com.example.softengineerwebpr.common.exception.BusinessLogicException; // 추가
import com.example.softengineerwebpr.common.exception.ErrorCode;         // 추가
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException; // 추가
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;
    private final OAuthProviderRepository oauthProviderRepository;
    private final UserOAuthConnectionRepository userOAuthConnectionRepository;
    private final UserCodeGenerator userCodeGenerator;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oauth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
        Map<String, Object> originalAttributes = oauth2User.getAttributes();
        OAuthAttributes oAuthAttributes = OAuthAttributes.of(registrationId, userNameAttributeName, originalAttributes);

        OAuthProvider provider = oauthProviderRepository.findByName(registrationId.toUpperCase())
                .orElseThrow(() -> {
                    log.warn("지원하지 않는 OAuth Provider 입니다: {}", registrationId);
                    return new OAuth2AuthenticationException("지원하지 않는 OAuth Provider입니다: " + registrationId);
                });

        Optional<UserOAuthConnection> userOAuthConnectionOptional = userOAuthConnectionRepository
                .findByOauthProviderAndOauth2UserId(provider, oAuthAttributes.getOauth2UserId());

        User user;
        boolean isNewSocialUser = false;

        if (userOAuthConnectionOptional.isPresent()) {
            user = userOAuthConnectionOptional.get().getUser();
            log.info("기존 소셜 연동 사용자 로그인: userId={}, provider={}, oauth2UserId={}", user.getIdx(), provider.getName(), oAuthAttributes.getOauth2UserId());
        } else {
            Optional<User> userByEmailOptional = userRepository.findByEmail(oAuthAttributes.getEmail());
            if (userByEmailOptional.isPresent() && oAuthAttributes.getEmail() != null) { // 이메일이 있는 경우에만 기존 사용자 연동 시도
                user = userByEmailOptional.get();
                connectSocialAccount(user, provider, oAuthAttributes.getOauth2UserId());
                log.info("기존 이메일 사용자에게 소셜 계정 연동: userId={}, provider={}, oauth2UserId={}", user.getIdx(), provider.getName(), oAuthAttributes.getOauth2UserId());
            } else {
                user = registerNewSocialUser(oAuthAttributes, provider); // 메소드명 변경 및 로직 이동
                isNewSocialUser = true;
            }
        }

        Map<String, Object> customAttributes = new HashMap<>();
        customAttributes.put("id", user.getIdx());
        customAttributes.put("email", user.getEmail() != null ? user.getEmail() : "");
        customAttributes.put("nickname", user.getNickname());
        customAttributes.put("profileImage", user.getProfileImage() != null ? user.getProfileImage() : "");
        customAttributes.put("provider", registrationId);
        customAttributes.put("isNewSocialUser", isNewSocialUser);

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                customAttributes,
                "id"
        );
    }

    private User registerNewSocialUser(OAuthAttributes attributes, OAuthProvider provider) {
        User newUser = User.builder()
                .nickname(attributes.getName()) // 소셜 프로필 이름으로 초기 닉네임 설정
                .email(attributes.getEmail())   // 이메일이 null일 수도 있음을 User 엔티티가 허용해야 함
                .profileImage(attributes.getPicture())
                .isOnline(true)
                .build();

        User savedUser = null;
        int maxAttempts = 10;
        for (int i = 0; i < maxAttempts; i++) {
            String identificationCode = userCodeGenerator.generateRandomFourDigitCode();
            newUser.setIdentificationCode(identificationCode); // User 엔티티에 setter 필요

            try {
                savedUser = userRepository.saveAndFlush(newUser);
                log.info("신규 소셜 사용자 등록 시도: nickname={}, identificationCode={}", attributes.getName(), identificationCode);
                break;
            } catch (DataIntegrityViolationException e) {
                log.warn("DataIntegrityViolationException for social user nickname {} with code {}. Attempt {}/{}. Retrying...",
                        attributes.getName(), identificationCode, i + 1, maxAttempts);
                if (i == maxAttempts - 1) {
                    throw new BusinessLogicException(ErrorCode.USER_REGISTRATION_FAILED,
                            "소셜 사용자 등록 중 내부 오류 발생 (식별 코드 할당 문제)");
                }
                // 예외 발생 시 객체 상태 초기화 (ID가 없는 상태로 만들기 위함)
                newUser = User.builder()
                        .nickname(attributes.getName())
                        .email(attributes.getEmail())
                        .profileImage(attributes.getPicture())
                        .isOnline(true)
                        .build();
            }
        }
        if (savedUser == null) {
            throw new BusinessLogicException(ErrorCode.USER_REGISTRATION_FAILED, "소셜 사용자 등록에 최종 실패했습니다.");
        }

        connectSocialAccount(savedUser, provider, attributes.getOauth2UserId());
        log.info("신규 소셜 사용자 등록 및 연동 완료: 사용자 ID={}, 소셜 ID={}", savedUser.getIdx(), attributes.getOauth2UserId());
        return savedUser;
    }

    private void connectSocialAccount(User user, OAuthProvider provider, String oauth2UserId) {
        UserOAuthConnection newConnection = UserOAuthConnection.builder()
                .user(user)
                .oauthProvider(provider)
                .oauth2UserId(oauth2UserId)
                .build();
        userOAuthConnectionRepository.save(newConnection);
        log.info("소셜 계정 연동 완료: userId={}, providerId={}, oauth2UserId={}", user.getIdx(), provider.getIdx(), oauth2UserId);
    }
}