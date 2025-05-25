package com.example.softengineerwebpr.common.dto;

import com.example.softengineerwebpr.common.exception.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ErrorResponse {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final int status;
    private final String error;
    private final String code;
    private final String message;
    private final String path; // 요청 경로 (선택적)
    private List<FieldErrorDetail> errors; // 필드 에러 상세 (선택적)

    // BusinessLogicException 용 생성자
    public ErrorResponse(ErrorCode errorCode, String path) {
        this.status = errorCode.getStatus().value();
        this.error = errorCode.getStatus().getReasonPhrase(); // 예: "Bad Request", "Not Found"
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.path = path;
    }

    // 일반적인 Exception 용 생성자 (예: 500 에러)
    public ErrorResponse(HttpStatus httpStatus, String code, String message, String path) {
        this.status = httpStatus.value();
        this.error = httpStatus.getReasonPhrase();
        this.code = code;
        this.message = message;
        this.path = path;
    }

    // MethodArgumentNotValidException (입력값 유효성 검증 실패) 용 생성자
    public ErrorResponse(HttpStatus httpStatus, String code, String message, String path, List<FieldErrorDetail> errors) {
        this.status = httpStatus.value();
        this.error = httpStatus.getReasonPhrase();
        this.code = code;
        this.message = message;
        this.path = path;
        this.errors = errors;
    }

    // 필드 에러 상세 정보를 위한 내부 클래스 또는 별도 DTO
    @Getter
    public static class FieldErrorDetail {
        private final String field;
        private final String value;
        private final String reason;

        public FieldErrorDetail(String field, Object value, String reason) {
            this.field = field;
            this.value = (value != null) ? value.toString() : null;
            this.reason = reason;
        }
    }
}