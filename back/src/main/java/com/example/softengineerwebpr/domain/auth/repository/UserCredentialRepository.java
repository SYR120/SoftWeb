package com.example.softengineerwebpr.domain.auth.repository;

import com.example.softengineerwebpr.domain.auth.entity.UserCredential;
import com.example.softengineerwebpr.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Long> {
    // 로그인 ID로 자격 증명 정보 조회 (일반 로그인 시 사용)
    Optional<UserCredential> findByLoginId(String loginId);

    // User 엔티티로 자격 증명 정보 조회
    Optional<UserCredential> findByUser(User user);

    // 로그인 ID 존재 여부 확인 (회원가입 시 중복 체크)
    boolean existsByLoginId(String loginId);
}
