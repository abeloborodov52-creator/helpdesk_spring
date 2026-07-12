package com.abeloborodov.helpdesk_spring.repository;


import com.abeloborodov.helpdesk_spring.model.Ticket;
import com.abeloborodov.helpdesk_spring.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryUserRepository implements UserRepository{
    private final List<User> users = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User findById(long id) {
        for (User currentUser : users) {
            if (currentUser.getId() == id) {
                return currentUser;
            }
        }
        return null;
    }
    public void save(User user) {
        users.add(user);
    }
}
