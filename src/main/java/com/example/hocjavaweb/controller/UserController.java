package com.example.hocjavaweb.controller;

import com.example.hocjavaweb.dto.CreateUserDTO;
import com.example.hocjavaweb.entity.UserEntity;
import com.example.hocjavaweb.repo.UserRepo;
import com.example.hocjavaweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("user")
    public String createUser(@RequestBody CreateUserDTO request) {
       return userService.createUser(request);
    }
    @GetMapping("users")
    public List<UserEntity> getAll(){
        return userRepo.getAll();
    }
}
