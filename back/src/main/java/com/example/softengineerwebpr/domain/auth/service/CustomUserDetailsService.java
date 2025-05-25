package com.example.softengineerwebpr.domain.auth.service;

import com.example.softengineerwebpr.domain.auth.entity.UserCredential;
import com.example.softengineerwebpr.domain.auth.repository.UserCredentialRepository;
import com.example.softengineerwebpr.domain.user.entity.User; // User 엔티티의 역할(role) 정보를 가져오기 위해 필요할 수 있음
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service("userDetailsService") // Bean 이름 명시 (선택적)
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserCredentialRepository userCredentialRepository;
    // private final UserRepository userRepository; // User의 역할을 가져오려면 필요

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        UserCredential userCredential = userCredentialRepository.findByLoginId(loginId)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + loginId));

        User user = userCredential.getUser(); // UserCredential을 통해 User 정보 가져오기

        // TODO: User 엔티티 또는 ProjectMember 등에서 실제 역할(Role) 정보를 가져와 GrantedAuthority 목록 생성
        // 현재는 임시로 "ROLE_USER" 부여.
        // 예시: List<GrantedAuthority> authorities = user.getRoles().stream()
        //                                         .map(role -> new SimpleGrantedAuthority(role.getName()))
        //                                         .collect(Collectors.toList());
        // 여기서는 User 엔티티에 역할 정보가 직접 없으므로, project_member 등을 통해 가져오거나 기본값 설정
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));


        return org.springframework.security.core.userdetails.User.builder()
                .username(userCredential.getLoginId()) // Spring Security에서 username으로 인식될 값
                .password(userCredential.getPassword()) // DB에 저장된 암호화된 비밀번호
                .authorities(authorities) // 역할(권한) 목록
                // .accountExpired(false)
                // .accountLocked(false)
                // .credentialsExpired(false)
                // .disabled(false)
                .build();
    }
}