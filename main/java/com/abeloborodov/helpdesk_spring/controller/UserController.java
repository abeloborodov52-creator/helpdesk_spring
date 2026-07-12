package com.abeloborodov.helpdesk_spring.controller;

import com.abeloborodov.helpdesk_spring.dto.CreateUserRequest;
import com.abeloborodov.helpdesk_spring.model.User;
import com.abeloborodov.helpdesk_spring.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {
        return  userService.findUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody CreateUserRequest request) {

        return userService.createUser(
                request.getUsername()
        );
    }

}
