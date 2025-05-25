package com.example.softengineerwebpr.domain.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user",
        uniqueConstraints = { // 기존 email 유니크 제약은 유지, nickname+identification_code 복합 유니크 제약 추가
                @UniqueConstraint(name = "uk_user_email", columnNames = "email"),
                @UniqueConstraint(name = "uk_user_nickname_identification_code", columnNames = {"nickname", "identification_code"})
        }
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;

    @Column(name = "nickname", nullable = false, length = 20)
    private String nickname;

    @Column(name = "email", length = 255) // unique = true 는 @Table의 uniqueConstraints로 이동
    private String email;

    @Column(name = "identification_code", nullable = false, length = 4)
    private String identificationCode;

    @Column(name = "profile_image", length = 255)
    private String profileImage;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "is_online", nullable = false) // DB 스키마에 NOT NULL DEFAULT FALSE 명시됨
    private boolean isOnline;

    // authProvider 필드는 사용자님의 결정에 따라 현재 포함하지 않았습니다.

    @Builder
    public User(String nickname, String email, String identificationCode, // 빌더에는 identificationCode 포함
                String profileImage, String bio, LocalDateTime lastLogin, boolean isOnline) {
        this.nickname = nickname;
        this.email = email;
        this.identificationCode = identificationCode; // 빌더에서 초기 설정 가능
        this.profileImage = profileImage;
        this.bio = bio;
        this.lastLogin = lastLogin;
        this.isOnline = isOnline;
    }

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    public void updateProfile(String nickname, String profileImage, String bio) {
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.bio = bio;
    }

    public void updateLastLogin() {
        this.lastLogin = LocalDateTime.now();
    }

    public void updateOnlineStatus(boolean isOnline) {
        this.isOnline = isOnline;
    }

    // 재시도 로직에서 identificationCode를 변경하기 위한 Setter 추가
    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }
}