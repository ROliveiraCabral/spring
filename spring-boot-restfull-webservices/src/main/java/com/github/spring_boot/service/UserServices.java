package com.github.spring_boot.service;

import com.github.spring_boot.entity.User;
import com.github.spring_boot.repository.UserRepository;
import com.github.spring_boot.service.interfaces.IUserServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServices implements IUserServices {

    private UserRepository userRepository;


    @Override
    public User getUserById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
