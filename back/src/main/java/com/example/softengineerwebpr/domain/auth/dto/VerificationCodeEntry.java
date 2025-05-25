package com.example.softengineerwebpr.domain.auth.dto;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class VerificationCodeEntry {
    private final String code;
    private final LocalDateTime expiryTime;

    public VerificationCodeEntry(String code, int expiryMinutes) {
        this.code = code;
        this.expiryTime = LocalDateTime.now().plusMinutes(expiryMinutes);
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiryTime);
    }
}