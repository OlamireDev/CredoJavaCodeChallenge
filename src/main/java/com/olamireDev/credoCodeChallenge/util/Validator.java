package com.olamireDev.credoCodeChallenge.util;

public class Validator {

    public static boolean isValid(String sessionId, String phoneNumber, String text){
        if(sessionId != null && text != null){
            String regex = "^\\d{11}$";
            return  phoneNumber.matches(regex);
        }
        return false;
    }

    public static boolean validName(String name){return name.matches("^[a-zA-Z' ]+$");
    }

    public static Boolean validBVN(String bvn){
        return bvn.matches("^\\d{11}$");
    }

    public static boolean validAmount(String amount){ return amount.matches("^\\d+(\\.\\d{1,2})?$"); }
}
