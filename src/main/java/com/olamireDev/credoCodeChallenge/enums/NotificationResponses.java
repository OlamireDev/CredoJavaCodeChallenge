package com.olamireDev.credoCodeChallenge.enums;

public enum NotificationResponses {
    DEPOSIT("Congratulations %s, \n You've deposited %.2f in your account"),
    WITHDRAW("Congratulations %s, \n You've withdrawn %.2f from your account");
    private final String output;

    NotificationResponses(String output) {
        this.output = output;
    }

    public String getOutput(){
        return output;
    }
}
