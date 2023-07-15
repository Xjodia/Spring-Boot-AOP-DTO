package com.example.usermanagementsystem.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTOUpdate {
    String email;
    String password;
    String phone;
    int age;
}
