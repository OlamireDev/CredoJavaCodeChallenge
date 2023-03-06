package com.olamireDev.credoCodeChallenge.service.impl;

import com.olamireDev.credoCodeChallenge.enums.NotificationResponses;
import com.olamireDev.credoCodeChallenge.service.NotificationService;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class NotificationServiceImpl implements NotificationService {
    @Override
    public void sendMessage(String phoneNumber, BigDecimal amount, String firstName, int type) {
        String send ="";
        if(type == 1){
            send = String.format(NotificationResponses.DEPOSIT.getOutput(), firstName, amount);
        }else if(type == 2){
            send = String.format(NotificationResponses.WITHDRAW.getOutput(), firstName, amount);
        }
        Message message = Message.creator(new PhoneNumber("+2348052253710"), new PhoneNumber("+13159042387"),
                send).create();
    }
}
