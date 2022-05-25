package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository
        extends JpaRepository<UserEntity, Long> {
     @Query(value = "select * from user u where u.email= ?1", nativeQuery = true)
     UserEntity loginUser(Optional<String> email);
}
