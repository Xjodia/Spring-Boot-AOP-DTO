package com.example.usermanagementsystem.utils.mapper;

import com.example.usermanagementsystem.dto.UserDTOCreate;
import com.example.usermanagementsystem.dto.UserDTOResponse;
import com.example.usermanagementsystem.dto.UserDTOUpdate;
import com.example.usermanagementsystem.entity.User;

public class UserMapper {
    public static User toUserCreate(UserDTOCreate userDTOCreate){
        return User.builder()
                .email(userDTOCreate.getEmail())
                .password(userDTOCreate.getPassword())
                .phone(userDTOCreate.getPhone())
                .age(userDTOCreate.getAge())
                .build();
    }

    public static UserDTOResponse toUserDTOResponse(User user){
        return UserDTOResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .phone(user.getPhone())
                .age(user.getAge())
                .build();
    }

    public static User toUserUpdate(UserDTOUpdate UserDTOUpdate){
        return User.builder()
                .email(UserDTOUpdate.getEmail())
                .password(UserDTOUpdate.getPassword())
                .phone(UserDTOUpdate.getPhone())
                .age(UserDTOUpdate.getAge())
                .build();
    }
}
