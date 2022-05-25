package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class loginService implements LoginServiceInterface{

    @Autowired
    private UserRepository userRepository;

    public loginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Boolean loginUser(Optional<String> email, Optional<String> password) {
        UserEntity user = userRepository.loginUser(email);
        if (password.isPresent() && !password.get().equals("")){
            if (user.getPassword().equals(password.get())){
                return true;
            }
            return false;
        }
        return false;
    }
}
