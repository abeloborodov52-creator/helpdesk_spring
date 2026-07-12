package com.abeloborodov.helpdesk_spring.service;
import com.abeloborodov.helpdesk_spring.model.TicketStatus;
import jakarta.annotation.PostConstruct;
import com.abeloborodov.helpdesk_spring.model.Ticket;
import com.abeloborodov.helpdesk_spring.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryTicketService implements TicketService {

    private final TicketRepository repository;

    private Long nextId = 1L;

    public InMemoryTicketService(TicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ticket createTicket(String title, String description) {

        Ticket ticket = new Ticket(nextId++, title, description, TicketStatus.OPEN);
        repository.save(ticket);
        return ticket;
    }

    @Override
    public List<Ticket> getAllTickets() {
        return repository.findAll();
    }

    @Override
    public Ticket findById(Long id) {
        return repository.findById(id);
    }
    @Override
    public Ticket changeStatus(long id, TicketStatus status) {
        Ticket foundTicket = findById(id);
        if (foundTicket == null) {
            return null;
        }
        if (status == null) {
            return null;
        }
        foundTicket.setStatus(status);
        return foundTicket;
    }

    @Override
    public void deleteTicket(long id) {
        repository.deleteById(id);
    }

    @PostConstruct
    public void init() {
        createTicket("Не работает мышь", "Компьютер не видит мышь");
        createTicket("Не включается принтер", "После включения ничего не происходит");
    }
}
