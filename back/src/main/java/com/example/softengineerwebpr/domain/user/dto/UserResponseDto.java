package com.example.softengineerwebpr.domain.user.dto; // 또는 domain.auth.dto

import com.example.softengineerwebpr.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {
    private Long idx;
    private String nickname;
    private String email;
    private String identificationCode;
    private String profileImage;
    private String bio;
    private LocalDateTime lastLogin;
    private boolean isOnline;
    // private String token; // JWT를 사용하지 않으므로 토큰은 불필요

    @Builder
    public UserResponseDto(Long idx, String nickname, String email, String identificationCode,
                           String profileImage, String bio, LocalDateTime lastLogin, boolean isOnline) {
        this.idx = idx;
        this.nickname = nickname;
        this.email = email;
        this.identificationCode = identificationCode;
        this.profileImage = profileImage;
        this.bio = bio;
        this.lastLogin = lastLogin;
        this.isOnline = isOnline;
    }

    public static UserResponseDto fromEntity(User user) {
        if (user == null) return null;
        return UserResponseDto.builder()
                .idx(user.getIdx())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .identificationCode(user.getIdentificationCode())
                .profileImage(user.getProfileImage())
                .bio(user.getBio())
                .lastLogin(user.getLastLogin())
                .isOnline(user.isOnline())
                .build();
    }
}