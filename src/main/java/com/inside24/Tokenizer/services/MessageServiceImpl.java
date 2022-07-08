package com.inside24.Tokenizer.services;

import com.inside24.Tokenizer.model.Message;
import com.inside24.Tokenizer.repository.MessageRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;
    private UserService userService;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, UserService userService) {
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

    @Override
    public Message getMessageByUser(String name) {
        return messageRepository.getByUser(userService.findByName(name));
    }

    @Override
    public List<String> getAllMessagesText(String name) {
        return messageRepository.getAllMessagesText(name);
    }

    @Override
    public List<String> getLastMessagesText(String name, Long quantity) {
        return messageRepository.getLastMessagesText(name, quantity);
    }

    @Override
    public void saveMessage(String name, String text) {
        messageRepository.saveAndFlush(new Message(text, userService.findByName(name)));
    }
}
