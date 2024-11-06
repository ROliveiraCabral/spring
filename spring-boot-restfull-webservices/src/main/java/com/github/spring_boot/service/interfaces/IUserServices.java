package com.github.spring_boot.service.interfaces;

import com.github.spring_boot.entity.User;

import java.util.List;

public interface IUserServices {

    User getUserById(long id);

    List<User> getAllUsers();

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(long id);
}
