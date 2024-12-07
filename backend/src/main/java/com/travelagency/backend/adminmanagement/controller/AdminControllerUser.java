package com.travelagency.backend.adminmanagement.controller;

import com.travelagency.backend.adminmanagement.services.AdminServicesUser;
import com.travelagency.backend.usermanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/user")
public class AdminControllerUser {
    private AdminServicesUser userServicesAdmin;
    @Autowired
    public AdminControllerUser(AdminServicesUser userServicesAdmin) {
        this.userServicesAdmin = userServicesAdmin;
    }

    //Get all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userServicesAdmin.getAllUsers();
    }

    // Get a specific user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userServicesAdmin.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Make a new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userServicesAdmin.createUser(user));
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userServicesAdmin.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
