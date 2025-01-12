package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.entity.*;
import com.example.service.*;

import java.util.ArrayList;
import java.util.List;


/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
//@RequestMapping("8080")
public class SocialMediaController {

    private AccountService accountService;
    private MessageService messageService;

    
    public SocialMediaController(AccountService accountService, MessageService messageService){
        this.accountService = accountService;
        this.messageService = messageService;
    }

    
    @PostMapping("/register")
    public ResponseEntity<Account> postAccountHandler(@RequestBody Account acc) {
        if(accountService.getAccountList().contains(acc)) {
            return ResponseEntity.status(409).body(acc);
        } else {
            Account addedAccount = accountService.createAccount(acc);
            if(addedAccount != null) {
                return ResponseEntity.status(200).body(acc);
            } else {
                return ResponseEntity.status(400).body(acc);
            }
        }
    }

    @PostMapping("/login")
    private ResponseEntity<Account> postLoginHandler(@RequestBody Account acc) {
        accountService.verifyLogin(acc);
        return ResponseEntity.status(200).body(acc);
    }

    @PostMapping("/messages")
    private ResponseEntity<Message> postMessageHandler(@RequestBody Message message) {
        
        return ResponseEntity.status(200).body(message);
    }

    @GetMapping("/messages")
    private void getAllMessagesHandler(@RequestBody Account acc) {

    }

    @GetMapping("/messages")
    private ResponseEntity<Message> getAMessageHandler(@RequestBody int messageId) {
        Message message = messageService.getAMessage(messageId);
        return ResponseEntity.status(200).body(message);
    }

    @DeleteMapping("/messages/{messageId}")
    private void deleteMessageHandler(@PathVariable int messageId) {

    }
    
    @PatchMapping("/messages/{messageId}")
    private void patchMessageHandler(@PathVariable int messageId) {

    }

    @GetMapping("/accounts/{accountId}/messages")
    public List<Message> getAllMessages(@PathVariable int accountId) {
        return null;
    }

    







}
