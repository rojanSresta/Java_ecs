package com.texas.ecommerce.service;

import com.texas.ecommerce.dto.UserDto;
import com.texas.ecommerce.model.User;

import java.util.List;

public interface UserService {
    Integer save(UserDto userDto);
    UserDto getById(Integer id);
    List<UserDto> getAll();
    void deleteById(Integer id);
    Integer updateById(Integer id, UserDto userDto);
    User login(String email, String pass);
}