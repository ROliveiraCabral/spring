package com.github.spring_boot.controller;

import com.github.spring_boot.entity.User;
import com.github.spring_boot.service.interfaces.IUserServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private IUserServices userServices;

    @GetMapping("/{id}")
    ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        User user = userServices.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userServices.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


}
