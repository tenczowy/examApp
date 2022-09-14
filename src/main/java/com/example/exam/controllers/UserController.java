package com.example.exam.controllers;


import com.example.exam.models.User;
import com.example.exam.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@RestController // This means that this class is a Controller
@RequestMapping(path= "user") // This means URL's start with /demo (after Application path)
public class UserController {


    @Autowired
    private UserRepository userRepository;


}