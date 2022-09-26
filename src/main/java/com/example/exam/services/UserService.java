package com.example.exam.services;


import com.example.exam.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;



@Service
public interface UserService{
    UserDetails loadUserByUsername(String email);

    String signUpUser(User user);

    int enableUser(String mail);
}
