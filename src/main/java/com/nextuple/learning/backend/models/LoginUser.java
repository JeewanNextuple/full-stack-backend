package com.nextuple.learning.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
public class LoginUser {

    private String email;
    private String password;

}
