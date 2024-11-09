package com.github.spring_boot.service;

import com.github.spring_boot.dto.UserDto;
import com.github.spring_boot.entity.User;
import com.github.spring_boot.mapper.UserMapper;
import com.github.spring_boot.repository.UserRepository;
import com.github.spring_boot.service.interfaces.IUserServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServices implements IUserServices {

    private UserRepository userRepository;


    @Override
    public UserDto getUserById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return UserMapper.mapToUserDto(user);
        }
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User savedUser = userRepository.save(UserMapper.mapToUser(userDto));
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if (optionalUser.isPresent()) {
            userRepository.save(user);
            return UserMapper.mapToUserDto(user);
        }
        return null;
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

}
