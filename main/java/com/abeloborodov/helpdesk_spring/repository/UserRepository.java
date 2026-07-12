package com.abeloborodov.helpdesk_spring.repository;


import com.abeloborodov.helpdesk_spring.model.User;

import java.util.List;

public interface UserRepository {

    void save(User user);

    List<User> getAllUsers();

    User findById(long id);


}
