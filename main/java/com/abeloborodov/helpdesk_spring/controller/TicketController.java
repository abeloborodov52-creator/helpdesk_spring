package com.abeloborodov.helpdesk_spring.controller;

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
                request.getDescription()

        );
    }
    @PutMapping("/{id}/status")
    public Ticket changeStatus(
            @PathVariable long id,
            @RequestBody ChangeStatusRequest request) {

        return ticketService.changeStatus(id, request.getStatus());
    }
}
