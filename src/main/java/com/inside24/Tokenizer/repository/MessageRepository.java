package com.inside24.Tokenizer.repository;

import com.inside24.Tokenizer.model.Message;
import com.inside24.Tokenizer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>  {
    Message getByUser(User user);

    @Query(value = "select text from messages where user_id = (select id from users where name = :nameParam)", nativeQuery = true)
    List<String> getAllMessagesText(@Param("nameParam") String name);

    @Query(value = "SELECT text FROM messages where user_id = (select id from users where name = :nameParam) ORDER BY date DESC LIMIT :limitParam" , nativeQuery = true)
    List<String> getLastMessagesText(@Param("nameParam") String name,@Param("limitParam") Long quantity);
}
