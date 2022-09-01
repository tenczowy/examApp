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

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }


    // This returns a JSON or XML
    // Returns all users
    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    // This returns a JSON or XML
    // Returns user selected by name
    @GetMapping(path="/select")
    public @ResponseBody Iterable<User> selectUser(@RequestParam String name){
         return userRepository.findUserByName(name);
    }

    //deletes user by name
    @Transactional
    @PostMapping(path="/delete")
    public @ResponseBody String deleteUser (@RequestParam String name){
        if(userRepository.existsUserByName(name)){
            userRepository.deleteUserByName(name);
            return "Successfully deleted.";
        }else {
            return "User " + name + " not found.";
        }


    }
}