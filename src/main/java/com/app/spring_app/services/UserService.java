package com.app.spring_app.services;

import com.app.spring_app.entities.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    User createUser(User user);

    User updateUserById(Long id, User user);

    void deleteUserById(Long id);

    Optional<User> getUserById(Long id);

    User getUserByUsername(String username);
}
