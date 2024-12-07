package com.travelagency.backend.usermanagement.controller;

import com.travelagency.backend.tripmanagement.model.Trip;
import com.travelagency.backend.tripmanagement.service.TripServices;
import com.travelagency.backend.usermanagement.model.User;
import com.travelagency.backend.usermanagement.service.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserServices userService;

    public UserController(UserServices userService) {
        this.userService = userService;
    }

    // Get user information by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update user information
   /* @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        try {
            return ResponseEntity.ok(userService.updateUser(id, updatedUser));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }*/

    // Delete user account
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // Get all trips
    @GetMapping("/trips")
    public List<Trip> getAllTrips() {
        return userService.getAllTrips();
    }

    // Get a single trip by ID
    @GetMapping("/trips/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable Long id) {
        return userService.getTripById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
