package com.inside24.Tokenizer.services;

import com.inside24.Tokenizer.model.User;

import java.util.List;

public interface UserService   {


    User findByName(String name);

    User register(User user);

    List<User> getAll();


    User findById(Long id);

    void delete(Long id);
}
