package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    /*@Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }*/

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

    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }
}
