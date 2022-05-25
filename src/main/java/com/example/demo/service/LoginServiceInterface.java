package com.example.demo.service;

import java.util.Optional;

public interface LoginServiceInterface {

    Boolean loginUser(Optional<String> email, Optional<String> password);
}
