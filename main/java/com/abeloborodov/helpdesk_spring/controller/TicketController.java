package com.abeloborodov.helpdesk_spring.controller;

import com.abeloborodov.helpdesk_spring.dto.AssignUserRequest;
import com.abeloborodov.helpdesk_spring.dto.ChangeStatusRequest;
import com.abeloborodov.helpdesk_spring.dto.CreateTicketRequest;
import com.abeloborodov.helpdesk_spring.model.Ticket;
import com.abeloborodov.helpdesk_spring.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable long id) {
        return ticketService.findById(id);
    }

    @PostMapping
    public Ticket createTicket(@RequestBody CreateTicketRequest request) {

        return ticketService.createTicket(
                request.getTitle(),
                request.getDescription(),
                request.getAuthorId()
        );
    }
    @PutMapping("/{id}/status")
    public Ticket changeStatus(
            @PathVariable long id,
            @RequestBody ChangeStatusRequest request) {

        return ticketService.changeStatus(id, request.getStatus());
    }
    @PutMapping("/{id}/assignee")
    public Ticket assignUser(
            @PathVariable long id,
            @RequestBody AssignUserRequest request) {

        return ticketService.assignUser(id, request.getUserId());
    }

    @DeleteMapping("/{ticketId}/assignee")
    public Ticket removeAssignee(@PathVariable Long ticketId) {

        return ticketService.removeAssignee(ticketId);
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable long id) {
        ticketService.deleteTicket(id);
    }
}
