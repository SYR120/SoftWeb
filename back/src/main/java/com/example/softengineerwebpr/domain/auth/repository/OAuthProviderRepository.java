package com.example.softengineerwebpr.domain.auth.repository;

import com.example.softengineerwebpr.domain.auth.entity.OAuthProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OAuthProviderRepository extends JpaRepository<OAuthProvider, Long> {

    // 제공자 이름으로 정보 조회 (예: "NAVER", "KAKAO")
    Optional<OAuthProvider> findByName(String name);
}
