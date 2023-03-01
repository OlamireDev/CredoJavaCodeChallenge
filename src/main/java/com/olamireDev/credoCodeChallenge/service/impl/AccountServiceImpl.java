package com.olamireDev.credoCodeChallenge.service.impl;

import com.olamireDev.credoCodeChallenge.enums.AccountResponses;
import com.olamireDev.credoCodeChallenge.enums.Responses;
import com.olamireDev.credoCodeChallenge.model.Account;
import com.olamireDev.credoCodeChallenge.repository.AccountRepository;
import com.olamireDev.credoCodeChallenge.service.AccountService;
import com.olamireDev.credoCodeChallenge.util.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    public String createAccount(String input, String phoneNumber) {
        String[] inputs = input.split("\\*");
        if(accountRepository.findById(phoneNumber).isEmpty()) {
            if (inputs.length == 1) {
                return AccountResponses.ENTER_NAME.getOutput();
            }
            if (inputs.length == 2) {
                if(Validator.validName(inputs[1])){
                    return AccountResponses.ENTER_BVN.getOutput();
                }
                return  AccountResponses.INVALID_NAME.getOutput();
            }
            if(inputs.length ==3){
                if(Validator.validName(inputs[1]) && Validator.validBVN(inputs[2])){
                    String[] names = inputs[1].split(" ");
                    String firstname =names[0];
                    String lastname = "";
                    if(names.length >1){
                        lastname = names[1];
                    }
                    Account newAccount = new Account(phoneNumber, firstname, lastname, inputs[2]);
                    accountRepository.save(newAccount);
                    return String.format(AccountResponses.REGISTRATION_COMPLETE.getOutput(), inputs[1], phoneNumber);
                }
                return AccountResponses.INVALID_BVN.getOutput();
            }
        }
        return Responses.ACCOUNT_EXISTS.getOutput();
    }

    @Override
    public String getBalance(String phoneNumber) {
        Optional<Account> dbAccount = accountRepository.findById(phoneNumber);
        if(dbAccount.isPresent()){
            return String.format(AccountResponses.ACCOUNT_BALANCE.getOutput(), dbAccount.get().getWallet());
        }
        return Responses.ACCOUNT_DOESNT_EXIST.getOutput();
    }
}
