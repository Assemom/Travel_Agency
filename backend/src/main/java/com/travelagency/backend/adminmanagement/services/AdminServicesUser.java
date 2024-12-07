package com.travelagency.backend.adminmanagement.services;

import com.travelagency.backend.usermanagement.model.User;
import com.travelagency.backend.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServicesUser {
    private final UserRepository userRepository;

    @Autowired
    public AdminServicesUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Get a specific user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    //Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Delete a user by ID
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
