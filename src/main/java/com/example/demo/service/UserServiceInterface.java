package com.example.demo.service;

import com.example.demo.models.User;

import java.util.List;
public interface UserServiceInterface {
        User saveUser(User user);

        List<User> fetchUserList();

        User updateUser(User user, Long userId);

        void deleteUserById(Long userId);
}
