package com.example.softengineerwebpr.common.service;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);
}