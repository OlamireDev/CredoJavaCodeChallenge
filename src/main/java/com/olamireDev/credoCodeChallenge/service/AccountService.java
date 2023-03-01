package com.olamireDev.credoCodeChallenge.service;

public interface AccountService {
    String createAccount(String input, String phoneNumber);
    String getBalance(String phoneNumber);
}
