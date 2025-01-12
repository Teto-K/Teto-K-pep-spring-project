package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        if(account.getUsername() != "" && account.getUsername() != null && account.getPassword().length() >= 4) {
            return accountRepository.createAccount(account);
        } else {
            return null;
        }
    }

    public Account verifyLogin(Account account) {
        return accountRepository.findAccountByUsernameAndPassword(account.getUsername(), account.getPassword());
    }

    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }
}
