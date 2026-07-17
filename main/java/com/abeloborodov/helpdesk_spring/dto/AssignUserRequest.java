package com.abeloborodov.helpdesk_spring.dto;

public class AssignUserRequest {
    private long userId;

    public AssignUserRequest() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
