package com.example.softengineerwebpr.common.service.impl;

import com.example.softengineerwebpr.common.exception.BusinessLogicException;
import com.example.softengineerwebpr.common.exception.ErrorCode;
import com.example.softengineerwebpr.common.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;
    // application.properties에 설정된 spring.mail.username 주소
    // @Value("${spring.mail.username}") private String fromEmail;

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            // message.setFrom(fromEmail); // application.properties에서 spring.mail.username이 보내는 사람이 됨
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);
            log.info("Verification email sent successfully to {}", to);
        } catch (MailException e) {
            log.error("Failed to send email to {}: {}", to, e.getMessage());
            // BusinessLogicException을 던져서 GlobalExceptionHandler가 처리하도록 함
            throw new BusinessLogicException(ErrorCode.EMAIL_SEND_FAILED);
        }
    }
}