package com.abeloborodov.helpdesk_spring.repository;

import com.abeloborodov.helpdesk_spring.model.Ticket;

import java.util.List;

public interface TicketRepository {

    void save(Ticket ticket);

    List<Ticket> findAll();

    Ticket findById(Long id);

    void deleteById(long id);
}
