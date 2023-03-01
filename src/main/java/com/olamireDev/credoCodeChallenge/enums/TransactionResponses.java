package com.olamireDev.credoCodeChallenge.enums;

public enum TransactionResponses {

    ENTER_AMOUNT("CON Please enter the amount you want to %s:"),
    OPERATION_COMPLETE("END you have successfully %s N %.2f into your account."),
    INVALID_AMOUNT("Invalid amount entered, try again.");

    private final String output;

    TransactionResponses(String output) {
        this.output = output;
    }

    public String getOutput(){
        return output;
    }
}
