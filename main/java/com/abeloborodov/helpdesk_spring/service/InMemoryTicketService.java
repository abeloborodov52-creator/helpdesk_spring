package com.abeloborodov.helpdesk_spring.service;
import com.abeloborodov.helpdesk_spring.model.Comment;
import com.abeloborodov.helpdesk_spring.model.TicketStatus;
import com.abeloborodov.helpdesk_spring.model.User;
import jakarta.annotation.PostConstruct;
import com.abeloborodov.helpdesk_spring.model.Ticket;
import com.abeloborodov.helpdesk_spring.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InMemoryTicketService implements TicketService {

    private final TicketRepository repository;
    private final UserService userService;

    private Long nextId = 1L;
    private long nextCommentId = 1;

    public InMemoryTicketService(TicketRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    @Override
    public Ticket createTicket(String title, String description, long authorId) {

        User author = userService.findUserById(authorId);

        if (author == null) {
            return null;
        }
        Ticket ticket = new Ticket(nextId++, title, description, TicketStatus.OPEN, author, null);
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

    public Ticket assignUser(long ticketId, long userId){
        Ticket ticket = findById(ticketId);
        if (ticket == null) {
            return null;
        }
        User user = userService.findUserById(userId);
        if (user == null) {
            return null;
        }
        ticket.setAssignee(user);
        return ticket;
    }

    public Ticket removeAssignee(long ticketId){
        Ticket ticket = findById(ticketId);

        if (ticket == null) {
            return null;
        }

        ticket.setAssignee(null);

        return ticket;
    }

    public Comment addComment(long ticketId,
                              String text,
                              Long authorId){
        Ticket ticket = findById(ticketId);
        if (ticket == null) {
            return null;
        }
        User author = userService.findUserById(authorId);
        if (author == null) {
            return null;
        }
        Comment comment = new Comment(
                nextCommentId++,
                text,
                author,
                LocalDateTime.now());
        ticket.getComments().add(comment);
        return comment;
    }

    public List<Comment> getComments(long ticketId){
        Ticket ticket = findById(ticketId);
        if (ticket == null) {
            return null;
        }
        return ticket.getComments();

    }

    @Override
    public void deleteTicket(long id) {
        repository.deleteById(id);
    }

//    @PostConstruct
//    public void init() {
//        createTicket("Не работает мышь", "Компьютер не видит мышь");
//        createTicket("Не включается принтер", "После включения ничего не происходит");
//    }
}
