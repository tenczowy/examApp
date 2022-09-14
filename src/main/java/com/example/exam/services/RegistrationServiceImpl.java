package com.example.exam.services;


import com.example.exam.DAO.AppUserRole;
import com.example.exam.DAO.EmailValidator;
import com.example.exam.DAO.RegistrationRequest;
import com.example.exam.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService{

    private final UserService userService;
    private final EmailValidator emailValidator;

    @Override
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }

        return userService.signUpUser(
                new User(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
