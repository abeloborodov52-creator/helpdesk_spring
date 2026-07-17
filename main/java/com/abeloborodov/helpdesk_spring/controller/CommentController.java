package com.abeloborodov.helpdesk_spring.controller;

import com.abeloborodov.helpdesk_spring.dto.CreateCommentRequest;
import com.abeloborodov.helpdesk_spring.model.Comment;
import com.abeloborodov.helpdesk_spring.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets/{ticketId}/comments")
public class CommentController {

    private final TicketService ticketService;

    public CommentController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @GetMapping
    public List<Comment> getComments(
            @PathVariable Long ticketId) {

        return ticketService.getComments(ticketId);
    }

    @PostMapping
    public Comment addComment(
            @PathVariable Long ticketId,
            @RequestBody CreateCommentRequest request) {

        return ticketService.addComment(
                ticketId,
                request.getText(),
                request.getAuthorId());
    }



}
