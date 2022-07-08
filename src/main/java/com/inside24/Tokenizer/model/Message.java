package com.inside24.Tokenizer.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String text;

    public Message(String text, User user) {
        this.text = text;
        this.user = user;
    }

    @CreatedDate
    private Date date;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;




}
