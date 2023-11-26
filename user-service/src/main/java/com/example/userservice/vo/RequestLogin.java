package com.example.userservice.vo;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestLogin {
    @Email
    @NotNull(message = "Email cannot be null")
    @Size(min = 2, message = "Email cannot be less than two characters")
    private  String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password cannot be equals or greater than eight characters")
    private String password;
}
