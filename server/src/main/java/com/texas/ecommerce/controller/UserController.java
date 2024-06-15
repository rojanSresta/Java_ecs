package com.texas.ecommerce.controller;

import com.texas.ecommerce.dto.OrderDto;
import com.texas.ecommerce.dto.UserDto;
import com.texas.ecommerce.service.OrderService;
import com.texas.ecommerce.service.ProductService;
import com.texas.ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("http://localhost:5173")
public class UserController {
    private final UserService userService;
    private final OrderService orderService;

    public UserController(UserService userService, OrderService orderService){
        this.userService = userService;
        this.orderService = orderService;
    }

    @PostMapping("/save")
    public ResponseEntity saveUser(@Valid @RequestBody UserDto userDto){
        Integer data = userService.save(userDto);
        return ResponseEntity.ok(
                Map.of("message", "User added Successfully", "data", data)
        );
    }

    @GetMapping("/id/{id}")
    public ResponseEntity fetchUserById(@PathVariable("id") Integer id){
        UserDto data = userService.getById(id);
        return ResponseEntity.ok(
                Map.of("message", "User Fetched...", "data", data)
        );
    }

    @GetMapping("/list")
    public ResponseEntity fetchAllUsers(){
        List<UserDto> data = userService.getAll();
        return ResponseEntity.ok(
                Map.of("message", "User List Fetched..","data", data)
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return  ResponseEntity.ok(
                Map.of("message", "User deleted successfully!")
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUserById(@PathVariable Integer id, @RequestBody UserDto userDto){
        userService.updateById(id, userDto);
        return ResponseEntity.ok(
                Map.of("message", "User data updated successfully")
        );
    }
}
