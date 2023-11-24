package com.example.userservice.service;

import com.example.userservice.model.User;

import java.util.List;

public interface UserService {

    User getById(Long id);

    List<User> getAll();

    User create(User user);

    void delete(Long id);

}
