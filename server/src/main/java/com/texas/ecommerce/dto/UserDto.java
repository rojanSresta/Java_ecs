package com.texas.ecommerce.dto;

import com.texas.ecommerce.enums.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class UserDto {
    private Integer id;

    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    private String address;

    @NotEmpty(message = "Password cannot be empty")
    @Length(min = 8, max = 16, message = "Password must be in the length of 8 to 16")
    private String password;
    @Length(min = 10, max = 10, message = "Contact number length must be of 10")
    private String contact;
    private Role role;

    public UserDto() {
    }


    public UserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserDto(String name, String email, String address, String password, String contact, Role role) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.contact = contact;
        this.role = role;
    }

    public UserDto(Integer id, String name, String email, String address, String contact, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.contact = contact;
        this.role = role;
    }

    public UserDto(Integer id, String name, String email, String address, String password, String contact, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.contact = contact;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDto(String name, String email, String address, String contact, Role role) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.contact = contact;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
