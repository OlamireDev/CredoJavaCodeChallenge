package com.olamireDev.credoCodeChallenge.service;

import java.math.BigDecimal;

public interface NotificationService {
    void sendMessage(String phoneNumber, BigDecimal amount, String firstName, int type);
}
