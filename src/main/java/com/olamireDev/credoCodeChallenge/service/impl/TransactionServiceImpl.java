package com.olamireDev.credoCodeChallenge.service.impl;



import com.olamireDev.credoCodeChallenge.enums.Responses;
import com.olamireDev.credoCodeChallenge.enums.TransactionResponses;
import com.olamireDev.credoCodeChallenge.enums.TransactionType;
import com.olamireDev.credoCodeChallenge.model.Account;
import com.olamireDev.credoCodeChallenge.model.Transaction;
import com.olamireDev.credoCodeChallenge.repository.AccountRepository;
import com.olamireDev.credoCodeChallenge.repository.TransactionRepository;
import com.olamireDev.credoCodeChallenge.service.NotificationService;
import com.olamireDev.credoCodeChallenge.service.TransactionService;
import com.olamireDev.credoCodeChallenge.util.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;
    private  final NotificationService notificationService;
    @Override
    public String depositWithdraw(int type, String phoneNumber, String input) {
        String[] inputs = input.split("\\*");
        Optional<Account> oDBAccount = accountRepository.findById(phoneNumber);
        TransactionType transactionType = type == 1? TransactionType.DEPOSIT: TransactionType.WITHDRAW;
        if(oDBAccount.isPresent()) {
            if (inputs.length == 1) {
                return String.format(TransactionResponses.ENTER_AMOUNT.getOutput(), transactionType.getOutput());
            }
            if (inputs.length == 2) {
                if(Validator.validAmount(inputs[1])){
                    BigDecimal amount = new BigDecimal(inputs[1]);
                    Account dbAccount = oDBAccount.get();
                    if(type == 1){
                        dbAccount.setWallet(dbAccount.getWallet().add(amount));
                        notificationService.sendMessage(phoneNumber,  amount, dbAccount.getFirstname(),1);
                    }else {
                        if(dbAccount.getWallet().compareTo(amount) >=0) {
                            dbAccount.setWallet(dbAccount.getWallet().subtract(amount));
                            notificationService.sendMessage(phoneNumber,  amount, dbAccount.getFirstname(),1);
                        }
                        else {
                            return  TransactionResponses.INVALID_AMOUNT.getOutput();
                        }
                    }
                    dbAccount = accountRepository.save(dbAccount);
                    Transaction transaction = new Transaction(dbAccount, amount, transactionType);
                    transactionRepository.save(transaction);
                    return String.format(TransactionResponses.OPERATION_COMPLETE.getOutput(), transactionType.getOutput(), amount );
                }
                return  TransactionResponses.INVALID_AMOUNT.getOutput();
            }
        }
        return Responses.ACCOUNT_DOESNT_EXIST.getOutput();
    }
}
