package com.example.demo.controller;

import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.UserServiceInterface;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "user/")
public class UserController {
    @Autowired
    private UserServiceInterface userService;

    @PostMapping("/add")
    public User saveUser(
            @RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/userList")
    public List<User> fetchUserList() {
        return userService.fetchUserList();
    }

    @PutMapping("/update/{id}")
    public User
    updateUser(@RequestBody User user,
               @PathVariable("id") Long userId) {
        return userService.updateUser(
                user, userId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUserById(@PathVariable("id")
                                 Long userId) {
        userService.deleteUserById(
                userId);
        return "Deleted Successfully";
    }
}
