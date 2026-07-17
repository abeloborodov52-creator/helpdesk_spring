package com.abeloborodov.helpdesk_spring.dto;

public class CreateCommentRequest {
    private String text;

    private Long authorId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
