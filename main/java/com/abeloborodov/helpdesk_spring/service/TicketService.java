package com.abeloborodov.helpdesk_spring.service;

import com.abeloborodov.helpdesk_spring.model.Ticket;
import com.abeloborodov.helpdesk_spring.model.TicketStatus;

import java.util.List;

public interface TicketService {

    Ticket createTicket(String title, String description);

    List<Ticket> getAllTickets();

    Ticket findById(Long id);

    Ticket changeStatus(long id, TicketStatus status);

    void deleteTicket(long id);
}
