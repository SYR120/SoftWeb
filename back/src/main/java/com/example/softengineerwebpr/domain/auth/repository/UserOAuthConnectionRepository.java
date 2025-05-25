package com.example.softengineerwebpr.domain.auth.repository;

import com.example.softengineerwebpr.domain.auth.entity.UserOAuthConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.softengineerwebpr.domain.user.entity.User;
import com.example.softengineerwebpr.domain.auth.entity.OAuthProvider; // 생성하신 OAuthProvider 임포트
import java.util.Optional;

public interface UserOAuthConnectionRepository extends JpaRepository<UserOAuthConnection, Long> {

    // 수정된 메소드 이름: OAuth2UserId -> oauth2UserId
    Optional<UserOAuthConnection> findByOauthProviderAndOauth2UserId(OAuthProvider oauthProvider, String oauth2UserId);

    Optional<UserOAuthConnection> findByUserAndOauthProvider(User user, OAuthProvider oauthProvider);
}