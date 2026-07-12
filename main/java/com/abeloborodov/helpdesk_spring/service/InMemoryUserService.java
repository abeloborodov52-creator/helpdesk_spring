package com.abeloborodov.helpdesk_spring.service;



import com.abeloborodov.helpdesk_spring.model.Ticket;
import com.abeloborodov.helpdesk_spring.model.User;
import com.abeloborodov.helpdesk_spring.repository.TicketRepository;
import com.abeloborodov.helpdesk_spring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryUserService
        implements UserService {

    private final UserRepository repository;
    private long nextId = 1;

    public InMemoryUserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(String username) {
        User user = new User(nextId, username);
        repository.save(user);
        nextId++;
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }

    @Override
    public User findUserById(long id) {
        return repository.findById(id);
    }






}

