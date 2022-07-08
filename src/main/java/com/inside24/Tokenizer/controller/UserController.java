package com.inside24.Tokenizer.controller;

import com.inside24.Tokenizer.dto.RequestMessageDto;
import com.inside24.Tokenizer.services.MessageService;
import com.inside24.Tokenizer.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/messages/")
@Slf4j
public class UserController {

    MessageService messageService;
    UserService userService;

    @Autowired
    public UserController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
        log.info("ms contr started!");
    }

    @PostMapping("**")
    public ResponseEntity takeMessage(@RequestBody RequestMessageDto requestMessageDto) {
        if (requestMessageDto.getMessage().startsWith("history ")) {
            try {
                Long quantity = Long.parseLong(requestMessageDto.getMessage().substring(8));
                log.info("sending messages");
                Map<Object, Object> response = new HashMap<>();
                List<String> messageText = messageService.getLastMessagesText(requestMessageDto.getName(), quantity);
                int j = 1;
                for (int i = 0; i < messageText.size(); i++) {
                    response.put(j++, messageText.get(i));
                }
                return ResponseEntity.ok(response);

            } catch (NumberFormatException e) {
                String messageText = requestMessageDto.getMessage();
                messageService.saveMessage(requestMessageDto.getName(), messageText);
                log.info("message from user " + requestMessageDto.getName() + " saved");
            }
        } else {
            String messageText = requestMessageDto.getMessage();
            messageService.saveMessage(requestMessageDto.getName(), messageText);
            log.info("message from user " + requestMessageDto.getName() + " saved");
        }
        return null;
    }

}
