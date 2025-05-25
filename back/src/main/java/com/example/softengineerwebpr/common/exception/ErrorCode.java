package com.example.softengineerwebpr.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    // Auth
    NICKNAME_DUPLICATION(HttpStatus.CONFLICT, "AUTH_001", "이미 사용 중인 닉네임입니다."), // 닉네임 단독 중복 시 (만약 별도 체크한다면)
    EMAIL_DUPLICATION(HttpStatus.CONFLICT, "AUTH_002", "이미 사용 중인 이메일입니다."),
    LOGIN_ID_DUPLICATION(HttpStatus.CONFLICT, "AUTH_003", "이미 사용 중인 아이디입니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "AUTH_004", "해당 사용자를 찾을 수 없습니다."),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "AUTH_005", "비밀번호가 일치하지 않습니다."),
    UNSUPPORTED_OAUTH_PROVIDER(HttpStatus.BAD_REQUEST, "AUTH_006", "지원하지 않는 소셜 로그인 제공자입니다."),
    EMAIL_VERIFICATION_FAILED(HttpStatus.BAD_REQUEST, "AUTH_007", "이메일 인증에 실패했습니다. 인증번호를 확인해주세요."),
    EMAIL_SEND_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "AUTH_008", "이메일 발송에 실패했습니다. 잠시 후 다시 시도해주세요."),
    USER_REGISTRATION_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "AUTH_009", "사용자 등록 중 오류가 발생했습니다."), // 추가된 에러 코드
    USER_INFO_MISMATCH(HttpStatus.BAD_REQUEST, "AUTH_010", "입력하신 사용자 정보가 일치하지 않습니다."), // 추가
    PASSWORD_RESET_NOT_SUPPORTED_FOR_SOCIAL(HttpStatus.BAD_REQUEST, "AUTH_011", "소셜 로그인 사용자는 이 기능을 사용할 수 없습니다."), // 필요시 추가

    // Common
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "COMMON_001", "입력 값이 올바르지 않습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON_002", "서버 내부 오류가 발생했습니다.");
    // ... 다른 에러 코드 추가

    private final HttpStatus status;
    private final String code;
    private final String message;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}