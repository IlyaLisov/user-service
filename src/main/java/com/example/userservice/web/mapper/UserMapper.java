package com.example.userservice.web.mapper;

import com.example.userservice.model.User;
import com.example.userservice.web.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    List<UserDto> toDto(List<User> users);

    User toEntity(UserDto dto);

    List<User> toEntity(List<UserDto> dtos);

}
