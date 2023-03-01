package com.olamireDev.credoCodeChallenge.controller;


import com.olamireDev.credoCodeChallenge.enums.Responses;
import com.olamireDev.credoCodeChallenge.service.AccountService;
import com.olamireDev.credoCodeChallenge.service.TransactionService;
import com.olamireDev.credoCodeChallenge.util.Validator;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class USSDController {

    private final AccountService accountService;
    private final TransactionService transactionService;

    @GetMapping("/")
    public String home(){return "yes";}
    @PostMapping(path = "/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String uSSDResponder(@RequestParam("sessionId") String sessionId,
                                @RequestParam("phoneNumber") String phoneNumber,
                                @RequestParam("text") String text){
        if(Validator.isValid(sessionId, phoneNumber, text)){
            if(text.equals("")){
                return Responses.DEFAULT.getOutput();
            }else if(text.startsWith("1")){
                return accountService.createAccount(text, phoneNumber);
            }else if(text.startsWith("2")){
                return  transactionService.depositWithdraw(1, phoneNumber, text);
            }else if(text.startsWith("3")){
                return  transactionService.depositWithdraw(2, phoneNumber, text);
            }else if(text.startsWith("4")){
                return accountService.getBalance(phoneNumber);
            }
        }
        return "Server Error Processing Request";
    }
}
