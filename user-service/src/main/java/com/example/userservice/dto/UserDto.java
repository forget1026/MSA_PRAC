package com.example.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {
    private String email;

    private String name;

    private String pwd;

    private String userId;

    private Date createdAt;

    private String encryptedPwd;
}
