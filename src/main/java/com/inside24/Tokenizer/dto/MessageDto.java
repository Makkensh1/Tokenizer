package com.inside24.Tokenizer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.inside24.Tokenizer.model.Message;
import com.inside24.Tokenizer.model.User;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageDto {
    private String text;
    private User user;

    public Message toMessage() {
        Message message = new Message();
        message.setText(text);
        message.setUser(user);
        return message;
    }

    public static MessageDto fromMessage(Message message) {
        MessageDto messageDto = new MessageDto();
        messageDto.setText(message.getText());
        messageDto.setUser(message.getUser());
        return messageDto;
    }
}
