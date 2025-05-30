package com.example.softengineerwebpr.domain.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindPasswordRequestDto {

    @NotBlank(message = "아이디를 입력해주세요.")
    @Size(min = 8, max = 20, message = "아이디는 8자 이상 20자 이하입니다.") // SignUpRequestDto와 일관성 유지
    private String loginId;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;
}