package com.olamireDev.credoCodeChallenge.enums;

public enum TransactionType {
    WITHDRAW("Withdraw"),
    DEPOSIT("Deposit");

    private final String output;

    TransactionType(String output) {
        this.output = output;
    }

    public String getOutput(){
        return output;
    }
}
