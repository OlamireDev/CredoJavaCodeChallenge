package com.olamireDev.credoCodeChallenge.enums;

public enum AccountResponses {
    ENTER_NAME("CON Enter your firstname and lastname seperated by space."),
    INVALID_NAME("It appears your name has invalid characters in it, please enter a valid name."),
    ENTER_BVN("CON Enter your 11 Digit BVN"),
    INVALID_BVN("Enter a valid BVN"),
    REGISTRATION_COMPLETE("END Congratulation %s, your phone number: %s is now your account number.\n Use it for "+
            "transactions"),

    ACCOUNT_BALANCE("END Your account balance is: N %.2f");

    private final String output;

    AccountResponses(String output) {
        this.output = output;
    }

    public String getOutput(){
        return output;
    }
}
