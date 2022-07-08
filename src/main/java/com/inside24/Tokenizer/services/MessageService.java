package com.inside24.Tokenizer.services;

import com.inside24.Tokenizer.model.Message;

import java.util.List;

public interface MessageService {
    Message getMessageByUser(String name);
    List<String> getAllMessagesText(String name);
    List<String> getLastMessagesText(String name, Long quantity);

    void saveMessage(String name, String text);
 }
