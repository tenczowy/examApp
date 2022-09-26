package com.example.exam.services;

import com.example.exam.DAO.RegistrationRequest;
import org.springframework.stereotype.Service;


@Service
public interface RegistrationService {

    String register(RegistrationRequest request);
    String confirmToken(String token);
}
