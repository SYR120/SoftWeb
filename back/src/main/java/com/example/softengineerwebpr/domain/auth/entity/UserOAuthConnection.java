package com.example.softengineerwebpr.domain.auth.entity;

import com.example.softengineerwebpr.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user_oauth_connections",
        uniqueConstraints = { // (user_idx, provider_idx) 복합 유니크 키 설정
            @UniqueConstraint(
                    name = "uk_user_oauth_connection_user_provider",
                    columnNames = {"user_idx", "provider_idx"}
            )
        })
public class UserOAuthConnection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx; // 연결의 고유 식별자 (DB 스키마 INT -> Long 매핑)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx", nullable = false,
            foreignKey = @ForeignKey(name = "fk_user_oauth_connection_user"))
    private User user; // 우리 시스템의 사용자 (User 엔티티 참조)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_idx", nullable = false, foreignKey = @ForeignKey(name = "fk_user_oauth_connection_provider"))
    private OAuthProvider oauthProvider; // 연동된 OAuth 제공자 (OAuthProvider 엔티티 참조)

    @Column(name = "oauth2_user_id", nullable = false, length = 255)
    private String oauth2UserId; // 해당 OAuth 제공자에서의 사용자 고유 ID

    @Builder
    public UserOAuthConnection(User user, OAuthProvider oauthProvider, String oauth2UserId) {
        this.user = user;
        this.oauthProvider = oauthProvider;
        this.oauth2UserId = oauth2UserId;
    }
}
