package com.texas.ecommerce.service.impl;

import com.texas.ecommerce.dto.UserDto;
import com.texas.ecommerce.exception.UserNotFoundException;
import com.texas.ecommerce.model.User;
import com.texas.ecommerce.repo.UserRepo;
import com.texas.ecommerce.service.UserService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Integer save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setAddress(userDto.getAddress());
        user.setContact(userDto.getContact());
        user.setEmail(userDto.getEmail());

        String password = userDto.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);

        user.setRole(userDto.getRole());
        User savedUser = userRepo.save(user);
        return savedUser.getId();
    }

    @Override
    public UserDto getById(Integer id) {
        User user = userRepo.findById(id).orElseThrow(
                ()-> new UserNotFoundException("User not found")
        );
        UserDto userDto = new UserDto(
                user.getId(), user.getEmail(), user.getPassword(), user.getName(), user.getAddress(), user.getContact(), user.getRole()
        );
        return userDto;
    }

    @Override
    public List<UserDto> getAll() {
        List<User> userList= userRepo.findAll();
        List<UserDto> userDtoList = userList.stream().
                map(user->{
                    UserDto userDto = new UserDto(user.getId(), user.getName(), user.getAddress(), user.getEmail(), user.getPassword(),user.getContact(), user.getRole());
                    return userDto;
                }).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.findById(id).orElseThrow(
                ()-> new RuntimeException("User not found")
        );
        userRepo.deleteById(id);
    }

    @Override
    public Integer updateById(Integer id, UserDto userDto) {
        User user = userRepo.findById(id).orElseThrow(
                ()-> new RuntimeException("User not found")
        );
        user.setName(userDto.getName());
        user.setAddress(userDto.getAddress());
        user.setContact(userDto.getContact());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        User savedUser = userRepo.save(user);
        return savedUser.getId();
    }


}
