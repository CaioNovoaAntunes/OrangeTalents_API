package com.example.bankorange.dto;

import com.example.bankorange.model.User;
import lombok.Getter;

@Getter
public class UserDto {
    private String email;

    public UserDto(User user) {
        this.email = user.getEmail();
    }
}
