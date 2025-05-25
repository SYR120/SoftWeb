package com.example.softengineerwebpr.common.exception;

import com.example.softengineerwebpr.common.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice // 모든 @RestController에서 발생하는 예외를 처리
public class GlobalExceptionHandler {

    // 개발자가 직접 정의한 비즈니스 로직 예외 처리
    @ExceptionHandler(BusinessLogicException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessLogicException(BusinessLogicException e, HttpServletRequest request) {
        log.warn("BusinessLogicException occurred: {} - Path: {}", e.getMessage(), request.getRequestURI(), e);
        ErrorCode errorCode = e.getErrorCode();
        ErrorResponse errorResponse = new ErrorResponse(errorCode, request.getRequestURI());
        return new ResponseEntity<>(errorResponse, errorCode.getStatus());
    }

    // @Valid 어노테이션을 사용한 DTO 유효성 검증 실패 시 발생하는 예외 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.warn("MethodArgumentNotValidException occurred: {} - Path: {}", e.getMessage(), request.getRequestURI());

        List<ErrorResponse.FieldErrorDetail> fieldErrors = e.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorResponse.FieldErrorDetail(
                        error.getField(),
                        error.getRejectedValue(),
                        error.getDefaultMessage()))
                .collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                ErrorCode.INVALID_INPUT_VALUE.getCode(), // 공통 에러 코드 사용
                "입력 값 유효성 검증에 실패했습니다.", // 대표 메시지
                request.getRequestURI(),
                fieldErrors
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // 기타 처리되지 않은 모든 예외에 대한 처리 (500 Internal Server Error)
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception e, HttpServletRequest request) {
        log.error("Unhandled Exception occurred: {} - Path: {}", e.getMessage(), request.getRequestURI(), e);
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ErrorCode.INTERNAL_SERVER_ERROR.getCode(), // 공통 에러 코드 사용
                "서버 내부 오류가 발생했습니다. 관리자에게 문의해주세요.",
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // (선택적) Spring Security 관련 예외 처리 (예: AccessDeniedException, AuthenticationException 등)
    // @ExceptionHandler(AccessDeniedException.class)
    // protected ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request) { ... }
}