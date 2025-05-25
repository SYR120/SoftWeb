package com.example.softengineerwebpr.domain.auth.service;

import com.example.softengineerwebpr.domain.auth.dto.SignUpRequestDto;

public interface AuthService {
    void signUp(SignUpRequestDto signUpRequestDto);
    boolean isLoginIdAvailable(String loginId); // 아이디 사용 가능 여부 확인
    boolean isNicknameAvailable(String nickname); // 닉네임 사용 가능 여부 확인
    void sendVerificationEmail(String email);
    boolean verifySubmittedCode(String email, String submittedCode); // signUp 시 내부적으로 호출될 메소드
    void findLoginIdAndSendEmail(String email);
    void resetPasswordAndSendEmail(String loginId, String email);
}