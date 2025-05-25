package com.example.softengineerwebpr.common.dto;

import lombok.Getter;

@Getter
public class ApiResponse<T> {
    private final int status;
    private final String message;
    private final T data; // 성공 시 실제 데이터

    private ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // 성공 응답 (데이터 포함)
    public static <T> ApiResponse<T> success(int status, String message, T data) {
        return new ApiResponse<>(status, message, data);
    }

    // 성공 응답 (데이터 없음, 메시지만)
    public static <T> ApiResponse<T> success(int status, String message) {
        return new ApiResponse<>(status, message, null);
    }

    // 실패 응답은 GlobalExceptionHandler에서 ErrorResponse DTO를 사용
}