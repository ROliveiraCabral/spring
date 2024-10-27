package com.github.spring_boot.service.interfaces;

import com.github.spring_boot.entity.User;

public interface IUserServices {

    User getUserById(long id);

    User createUser(User user);
}
