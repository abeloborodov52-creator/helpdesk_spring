package com.abeloborodov.helpdesk_spring.repository;

import com.abeloborodov.helpdesk_spring.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryTicketRepository implements TicketRepository {

    private final List<Ticket> tickets = new ArrayList<>();

    @Override
    public void save(Ticket ticket) {
        tickets.add(ticket);
    }

    @Override
    public List<Ticket> findAll() {
        return tickets;
    }

    @Override
    public Ticket findById(Long id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId().equals(id)) {
                return ticket;
            }
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        tickets.removeIf(ticket -> ticket.getId() == id);
    }


}
