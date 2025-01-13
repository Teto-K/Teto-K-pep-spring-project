package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        if(account.getUsername() != "" && account.getUsername() != null && account.getPassword().length() >= 4) {
            return accountRepository.save(account);
        } else {
            return null;
        }
    }

    public Account verifyLogin(Account account) {
        return accountRepository.findByUsernameAndPassword(account.getUsername(), account.getPassword());
    }

    public boolean duplicateUsernameTest(String username) {
        List<Account> accounts = accountRepository.findAll();
        List<String> usernames = new ArrayList<String>();
        for(int i = 0; i < accounts.size(); i++) {
            usernames.add(accounts.get(i).getUsername());
        }
        if(usernames.contains(username)) {
            return true;
        } else {
            return false;
        }
    }
}
