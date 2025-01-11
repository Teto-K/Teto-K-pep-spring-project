package com.example.controller;

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
@RequestMapping("8080")
public class SocialMediaController {

    AccountService accountService;
    MessageService messageService;

    public SocialMediaController(){
        this.messageService = new MessageService();
        this.accountService = new AccountService(messageService);
    }

    
    @PostMapping("/register")
    public void postAccountHandler(@RequestBody Account acc) {

    }

    @PostMapping("/login")
    private void postLoginHandler(@RequestBody Account acc) {

    }

    @PostMapping("/messages")
    private void postMessageHandler(@RequestBody Account acc) {
        
    }

    @GetMapping("/messages")
    private void getAllMessagesHandler(@RequestBody Account acc) {

    }

    @GetMapping("/messages")
    private void getAMessageHandler(@RequestBody Account acc) {
    
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
