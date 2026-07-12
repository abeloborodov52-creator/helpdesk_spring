package com.abeloborodov.helpdesk_spring.dto;

public class CreateUserRequest {
    private String username;

    public CreateUserRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
