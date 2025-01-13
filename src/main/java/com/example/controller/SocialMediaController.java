package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.entity.*;
import com.example.service.*;

import java.util.List;


/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {

    private AccountService accountService;
    private MessageService messageService;

    @Autowired
    public SocialMediaController(AccountService accountService, MessageService messageService){
        this.accountService = accountService;
        this.messageService = messageService;
    }

    @PostMapping("/register")
    public ResponseEntity<Account> postAccountHandler(@RequestBody Account acc) {
        if(accountService.duplicateUsernameTest(acc.getUsername())) {
            return ResponseEntity.status(409).body(acc);
        }
        Account addedAccount = accountService.createAccount(acc);
        if(addedAccount != null) {
            return ResponseEntity.status(200).body(addedAccount);
        } else {
            return ResponseEntity.status(400).body(acc);
        }
    }

    @PostMapping("/login")
    private ResponseEntity<Account> postLoginHandler(@RequestBody Account acc) {
        Account verifiedAccount = accountService.verifyLogin(acc);
        if(verifiedAccount != null) {
            return ResponseEntity.status(200).body(verifiedAccount);
        } else {
            return ResponseEntity.status(401).body(acc);
        }
    }

    @PostMapping("/messages")
    private ResponseEntity<Message> postMessageHandler(@RequestBody Message message) {
        Message createdMessage = messageService.createMessage(message);
        if(createdMessage != null) {
            return ResponseEntity.status(200).body(message);
        } else {
            return ResponseEntity.status(400).body(message);
        }
    }

    @GetMapping("/messages")
    private ResponseEntity<List<Message>> getAllMessagesHandler() {
        return ResponseEntity.status(200).body(messageService.getAllMessages());
    }

    @GetMapping("/messages/{messageId}")
    private ResponseEntity<Message> getAMessageHandler(@PathVariable int messageId) {
        return ResponseEntity.status(200).body(messageService.getAMessage(messageId));
    }

    @DeleteMapping("/messages/{messageId}")
    private ResponseEntity<Integer> deleteMessageHandler(@PathVariable int messageId) {
        if(messageService.deleteMessage(messageId) == 1) {
            return ResponseEntity.status(200).body(1);
        } else {
            return ResponseEntity.status(200).body(null);
        }
    }
    
    @PatchMapping("/messages/{messageId}")
    private ResponseEntity<String> patchMessageHandler(@PathVariable int messageId, @RequestBody String message_text) {
        int updatedMessage = messageService.updateMessage(messageId, message_text);
        if(updatedMessage != 0) {
            return ResponseEntity.status(200).body("1");
        }
        return ResponseEntity.status(400).body("");
    }

    @GetMapping("/accounts/{accountId}/messages")
    public ResponseEntity<List<Message>> getAllMessages(@PathVariable int accountId) {
        return ResponseEntity.status(200).body(messageService.getAllMessagesById(accountId));
    }
}
