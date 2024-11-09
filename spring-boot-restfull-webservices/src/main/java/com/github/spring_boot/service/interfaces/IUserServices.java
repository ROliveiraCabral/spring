package com.github.spring_boot.service.interfaces;

import com.github.spring_boot.dto.UserDto;

import java.util.List;

public interface IUserServices {

    UserDto getUserById(long id);

    List<UserDto> getAllUsers();

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    void deleteUser(long id);
}
