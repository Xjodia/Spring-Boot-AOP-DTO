package com.example.usermanagementsystem.service.impl;

import com.example.usermanagementsystem.dto.UserDTOCreate;
import com.example.usermanagementsystem.dto.UserDTOResponse;
import com.example.usermanagementsystem.dto.UserDTOUpdate;
import com.example.usermanagementsystem.entity.User;
import com.example.usermanagementsystem.model.CustomError;
import com.example.usermanagementsystem.model.NotFoundException;
import com.example.usermanagementsystem.repository.UserDTORepository;
import com.example.usermanagementsystem.service.UserService;
import com.example.usermanagementsystem.utils.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDTORepository userRepository;
//    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    public UserDTOResponse createUser(UserDTOCreate userDTOCreate) {
//        User user = modelMapper.map(userDTOCreate, User.class);
        User user = UserMapper.toUserCreate(userDTOCreate);
        userRepository.save(user);
//        return modelMapper.map(user, UserDTOResponse.class);
        return UserMapper.toUserDTOResponse(user);
    }

    @Override
    public List<UserDTOResponse> getAllUser() {
        Optional<List<User>> userListOptional = Optional.of(userRepository.findAll());
        {
            List<User> userList = userListOptional.get();
            List<UserDTOResponse> userDTOResponseList = new ArrayList<>();
            for(User user : userList){
                UserDTOResponse userDTOResponse = UserMapper.toUserDTOResponse(user);
                userDTOResponseList.add(userDTOResponse);
            }
            return userDTOResponseList;
        }
//        return userList.stream()
//                .map(user -> modelMapper.map(user, UserDTOResponse.class))
//                .collect(Collectors.toList());
    }

    @Override
    public UserDTOResponse getUserById(int userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new NotFoundException(CustomError.builder()
                    .code("500")
                    .message("User does not found")
                    .build());
        }else {
            return UserMapper.toUserDTOResponse(userOptional.get());
        }
    }

    @Override
    public UserDTOResponse updateUser(UserDTOUpdate userDTOUpdate, int userId) {
        User user = UserMapper.toUserUpdate(userDTOUpdate);
        user.setId(userId);
        userRepository.save(user);
        return UserMapper.toUserDTOResponse(user);
    }

    @Override
    public UserDTOResponse deleteUser(int userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser
                .orElseThrow(() -> new NotFoundException(CustomError.builder()
                        .code("500")
                        .message("User does not found")
                        .build()));
        userRepository.delete(user);
        return UserMapper.toUserDTOResponse(user);
    }
}
