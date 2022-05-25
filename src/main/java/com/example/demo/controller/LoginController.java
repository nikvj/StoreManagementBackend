package com.example.demo.controller;

import com.example.demo.models.Login;
import com.example.demo.responseModels.LoginResponse;
import com.example.demo.service.LoginServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginServiceInterface loginService;

    public LoginController(LoginServiceInterface loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody Login login) {
        Optional<String> email = Optional.ofNullable(login.getEmail());
        Optional<String> password = Optional.ofNullable(login.getPassword());
        LoginResponse response = new LoginResponse();
        try {
            boolean userLogIn = loginService.loginUser(email, password);
            if (userLogIn){
                response.setToken("sdfsdfsfsfsfsfsf");
                response.setLoginStatus(true);
                return response;
            }
            response.setLoginStatus(false);
            return response;
        }catch (Exception e){
            throw e;
        }
    }
}
