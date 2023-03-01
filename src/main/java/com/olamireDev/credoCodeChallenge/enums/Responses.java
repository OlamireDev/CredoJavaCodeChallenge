package com.olamireDev.credoCodeChallenge.enums;

public enum Responses {
    DEFAULT("CON Welcome to Credo Payment Service, what would you like to do? \n"+
            "1. Create an account \n"+
            "2. Deposit\n"+
            "3. Withdraw\n"+
            "4. Check Balance"),

    ACCOUNT_EXISTS("END This phone number is already registered on our service."),
    ACCOUNT_DOESNT_EXIST("END This phone number is not registered with our service");


    private final String output;

    Responses(String output) {
        this.output = output;
    }

    public String getOutput(){
        return output;
    }
}
