package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.models.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
        return user;
    }

    @Override
    public List<User> fetchUserList() {
        List<UserEntity> userEntityList =  userRepository.findAll();
        List<User> userList = userEntityList.stream().map(emp -> new User(
                emp.getId(), emp.getName(), emp.getEmail(), emp.getPassword()
        )).collect(Collectors.toList());
        return userList;
    }

        @Override
        public User updateUser(User user, Long userId)
        {
            UserEntity userDB
                    = userRepository.findById(userId)
                    .get();

            if (Objects.nonNull(user.getName())
                    && !"".equalsIgnoreCase(
                    user.getName())) {
                userDB.setName(
                        user.getName());
            }

            if (Objects.nonNull(user.getEmail())
                    && !"".equalsIgnoreCase(user.getEmail())) {
                userDB.setEmail(user.getEmail());
            }

            userRepository.save(userDB);
            return user;
        }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}
