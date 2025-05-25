package com.example.softengineerwebpr.domain.auth.controller;

import com.example.softengineerwebpr.domain.auth.dto.FindIdRequestDto;
import com.example.softengineerwebpr.domain.auth.dto.FindPasswordRequestDto;
import com.example.softengineerwebpr.domain.auth.dto.SendVerificationEmailRequestDto;
import com.example.softengineerwebpr.domain.auth.dto.SignUpRequestDto;
import com.example.softengineerwebpr.domain.auth.service.AuthService;
import com.example.softengineerwebpr.common.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // 회원가입 API
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Void>> signUp(@Valid @RequestBody SignUpRequestDto signUpRequestDto) {
        log.info("회원가입 시도: {}", signUpRequestDto.getLoginId());
        authService.signUp(signUpRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(HttpStatus.CREATED.value(), "회원가입이 성공적으로 완료되었습니다.", null));
    }

    // 아이디 중복 확인 API
    @GetMapping("/check-login-id")
    public ResponseEntity<ApiResponse<Boolean>> checkLoginId(@RequestParam String loginId) {
        log.info("아이디 중복 확인 시도: {}", loginId);
        boolean isAvailable = authService.isLoginIdAvailable(loginId);
        if (isAvailable) {
            return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "사용 가능한 아이디입니다.", true));
        } else {
            // 중복된 경우, 성공 응답에 false를 담아 보내거나,
            // GlobalExceptionHandler에서 처리할 수 있도록 BusinessLogicException을 던질 수도 있습니다.
            // 여기서는 성공 응답에 false를 담는 방식으로 처리합니다.
            return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "이미 사용 중인 아이디입니다.", false));
        }
    }

    // 닉네임 중복 확인 API
    @GetMapping("/check-nickname")
    public ResponseEntity<ApiResponse<Boolean>> checkNickname(@RequestParam String nickname) {
        log.info("닉네임 중복 확인 시도: {}", nickname);
        boolean isAvailable = authService.isNicknameAvailable(nickname);
        if (isAvailable) {
            return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "사용 가능한 닉네임입니다.", true));
        } else {
            return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "이미 사용 중인 닉네임입니다.", false));
        }
    }

    // 이메일 인증번호 발송 API
    @PostMapping("/send-verification-email")
    public ResponseEntity<ApiResponse<Void>> sendVerificationEmail(@Valid @RequestBody SendVerificationEmailRequestDto requestDto) {
        log.info("Attempting to send verification email to: {}", requestDto.getEmail());
        authService.sendVerificationEmail(requestDto.getEmail());
        return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "인증번호가 성공적으로 발송되었습니다.", null));
    }

    @GetMapping("/status")
    public ResponseEntity<ApiResponse<Object>> getAuthStatus() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getPrincipal())) {
            return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "로그인 상태입니다.", authentication.getPrincipal()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ApiResponse.success(HttpStatus.UNAUTHORIZED.value(), "로그아웃 상태입니다.", null));
    }

    @PostMapping("/find-id")
    public ResponseEntity<ApiResponse<Void>> findId(@Valid @RequestBody FindIdRequestDto findIdRequestDto) {
        log.info("아이디 찾기 요청: email={}", findIdRequestDto.getEmail());
        authService.findLoginIdAndSendEmail(findIdRequestDto.getEmail());
        return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "가입 시 사용한 이메일로 아이디 정보를 발송했습니다. 이메일을 확인해주세요.", null));
    }

    @PostMapping("/find-password")
    public ResponseEntity<ApiResponse<Void>> findPassword(@Valid @RequestBody FindPasswordRequestDto findPasswordRequestDto) {
        log.info("비밀번호 찾기(임시 비밀번호 발급) 요청: loginId={}", findPasswordRequestDto.getLoginId());
        authService.resetPasswordAndSendEmail(findPasswordRequestDto.getLoginId(), findPasswordRequestDto.getEmail());
        return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(), "입력하신 이메일로 임시 비밀번호를 발송했습니다. 이메일을 확인해주세요.", null));
    }
}