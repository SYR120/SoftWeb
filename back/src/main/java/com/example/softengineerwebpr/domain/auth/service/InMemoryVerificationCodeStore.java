package com.example.softengineerwebpr.domain.auth.service;

import com.example.softengineerwebpr.domain.auth.dto.VerificationCodeEntry;
import org.springframework.stereotype.Component; // 또는 Service

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component // 또는 @Service
public class InMemoryVerificationCodeStore {
    // 동시성 문제를 고려하여 ConcurrentHashMap 사용
    private final Map<String, VerificationCodeEntry> codeStore = new ConcurrentHashMap<>();
    private static final int EXPIRY_MINUTES = 3; // 요구사항: 유효기간 3분 [cite: 2163]

    public void storeCode(String email, String code) {
        codeStore.put(email, new VerificationCodeEntry(code, EXPIRY_MINUTES));
    }

    public VerificationCodeEntry getCode(String email) {
        return codeStore.get(email);
    }

    public void removeCode(String email) {
        codeStore.remove(email);
    }
}