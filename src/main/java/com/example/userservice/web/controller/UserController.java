package com.example.userservice.web.controller;

import com.example.userservice.model.User;
import com.example.userservice.service.UserService;
import com.example.userservice.web.dto.UserDto;
import com.example.userservice.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public List<UserDto> getAll() {
        List<User> users = userService.getAll();
        return userMapper.toDto(users);
    }

    @PostMapping
    public UserDto create(@RequestBody UserDto dto) {
        User user = userMapper.toEntity(dto);
        user = userService.create(user);
        return userMapper.toDto(user);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }

}
