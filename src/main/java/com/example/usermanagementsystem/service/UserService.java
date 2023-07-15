package com.example.usermanagementsystem.service;

import com.example.usermanagementsystem.dto.UserDTOCreate;
import com.example.usermanagementsystem.dto.UserDTOResponse;
import com.example.usermanagementsystem.dto.UserDTOUpdate;

import java.util.List;

public interface UserService {
    UserDTOResponse createUser(UserDTOCreate userDTOCreate);

    List<UserDTOResponse> getAllUser();

    UserDTOResponse getUserById(int userId);

    UserDTOResponse updateUser(UserDTOUpdate userDTOUpdate, int userId);

    UserDTOResponse deleteUser(int userId);
}
