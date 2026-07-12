package com.abeloborodov.helpdesk_spring.service;


import com.abeloborodov.helpdesk_spring.model.Ticket;
import com.abeloborodov.helpdesk_spring.model.User;
import java.util.List;

public interface UserService {

    User createUser(String username);


    User findUserById(long id);

    List<User> getAllUsers();



}
