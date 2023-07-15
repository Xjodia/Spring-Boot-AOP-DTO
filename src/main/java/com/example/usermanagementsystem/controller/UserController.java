package com.example.usermanagementsystem.controller;


import com.example.usermanagementsystem.dto.UserDTOCreate;
import com.example.usermanagementsystem.dto.UserDTOResponse;
import com.example.usermanagementsystem.dto.UserDTOUpdate;
import com.example.usermanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping ("/users")
    public UserDTOResponse createUser(@RequestBody UserDTOCreate userDTOCreate){
            return userService.createUser(userDTOCreate);
    }
    
    @GetMapping("/users")
    public List<UserDTOResponse> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/users/{id}")
    public UserDTOResponse getUserDTOResponseById(@PathVariable(name = "id") int userId){
            return userService.getUserById(userId);
    }

    @PutMapping("/update_users/{id}")
    public UserDTOResponse updateUserById(@RequestBody UserDTOUpdate userDTOUpdate, @PathVariable(name = "id") int userId){
            return userService.updateUser(userDTOUpdate, userId);
    }

    @DeleteMapping("/users/{id}")
    public UserDTOResponse deleteUserById(@PathVariable(name = "id") int userId){
            return userService.deleteUser(userId);
    }

}
