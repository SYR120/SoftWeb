package com.example.softengineerwebpr.domain.auth.dto;

import com.example.softengineerwebpr.domain.user.entity.User; // 필요시 User 엔티티 빌더에 사용
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes; // 원본 소셜 서비스 사용자 정보
    private String nameAttributeKey;        // 사용자 이름 속성의 키 (예: "id", "response")
    private String oauth2UserId;            // 소셜 서비스의 사용자 고유 ID
    private String name;                    // 사용자 이름/닉네임
    private String email;                   // 사용자 이메일
    private String picture;                 // 사용자 프로필 사진 URL

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String oauth2UserId, String name, String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.oauth2UserId = oauth2UserId;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    // 각 소셜 타입(registrationId)별로 attributes에서 정보 추출하여 OAuthAttributes 객체 생성
    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        if ("naver".equals(registrationId)) {
            return ofNaver(userNameAttributeName, attributes);
        } else if ("kakao".equals(registrationId)) {
            return ofKakao(userNameAttributeName, attributes);
        }
        // 다른 소셜 서비스 추가 시 여기에 else if 추가
        throw new IllegalArgumentException("지원하지 않는 소셜 로그인입니다: " + registrationId);
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get(userNameAttributeName); // 네이버는 "response" 키 하위에 사용자 정보가 있음

        return OAuthAttributes.builder()
                .oauth2UserId((String) response.get("id"))
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .picture((String) response.get("profile_image"))
                .attributes(response) // "response" 내부 맵을 attributes로 저장
                .nameAttributeKey("id") // 실제 고유 식별 키 (response.id)
                .build();
    }

    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> profile = (Map<String, Object>) kakaoAccount.get("profile");

        return OAuthAttributes.builder()
                .oauth2UserId(String.valueOf(attributes.get("id"))) // 카카오의 고유 ID
                .name((String) profile.get("nickname"))
                .email((String) kakaoAccount.get("email"))
                .picture((String) profile.get("profile_image_url"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName) // "id"
                .build();
    }

    // User 엔티티 생성 (신규 가입 시) - 이 부분은 CustomOAuth2UserService에서 직접 처리하는 것이 더 적절할 수 있음
    // public User toEntity() {
    //     return User.builder()
    //             .nickname(name)
    //             .email(email)
    //             .profileImage(picture)
    //             // .role(Role.GUEST) // 기본 권한 설정
    //             .build();
    // }
}