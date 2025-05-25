package com.example.softengineerwebpr.common.util;

import org.springframework.stereotype.Component;
import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// UserRepository 의존성 제거
@Component
public class UserCodeGenerator {

    /**
     * 랜덤 4자리 숫자 식별 코드를 생성합니다. (DB 중복 검사 없음)
     * @return 랜덤 4자리 숫자 식별 코드 (예: "0000" ~ "9999")
     */
    public String generateRandomFourDigitCode() {
        SecureRandom random = new SecureRandom();
        return String.format("%04d", random.nextInt(10000));
    }

    /**
     * 지정된 길이의 숫자 인증 코드를 생성합니다. (이메일 인증 등에 사용)
     * @param length 생성할 코드의 길이
     * @return 생성된 숫자 코드 문자열
     */
    public String generateNumericVerificationCode(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder codeBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            codeBuilder.append(random.nextInt(10));
        }
        return codeBuilder.toString();
    }


    /**
     * 지정된 길이의 랜덤 영숫자 임시 비밀번호를 생성합니다.
     * @param length 생성할 비밀번호의 길이
     * @return 랜덤 임시 비밀번호 문자열
     */
    public String generateRandomTemporaryPassword(int length) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // 포함할 문자셋
        SecureRandom random = new SecureRandom();
        return IntStream.range(0, length)
                .map(i -> random.nextInt(chars.length()))
                .mapToObj(randomIndex -> String.valueOf(chars.charAt(randomIndex)))
                .collect(Collectors.joining());
    }
}