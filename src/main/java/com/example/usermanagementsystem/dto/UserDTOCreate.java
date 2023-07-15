package com.example.usermanagementsystem.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTOCreate {
    String email;
    String password;
    String phone;
    int age;
}
