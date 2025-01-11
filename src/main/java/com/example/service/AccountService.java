package com.example.service;

import com.example.entity.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private List<Account> accountList = new ArrayList<>();

    private MessageService messageService;

    @Autowired
    public AccountService(MessageService messageService) {
        this.messageService = messageService;
    }

    public Account createAccount(Account account) {

        return null;
    }

    public Account verifyLogin(Account account) {
        
        return null;
    }
}
