package com.travelagency.backend.usermanagement.service;

import com.travelagency.backend.tripmanagement.model.Trip;
import com.travelagency.backend.tripmanagement.repository.TripRepository;
import com.travelagency.backend.usermanagement.model.User;
import com.travelagency.backend.usermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices{
    private final UserRepository userRepository;
    private final TripRepository tripRepository;

    public UserServices(UserRepository userRepository, TripRepository tripRepository) {
        this.userRepository = userRepository;
        this.tripRepository = tripRepository;
    }

    // Get user information
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    // Update user information
   /* public User updateUser(Long userId, User updatedUser) {
        return userRepository.findById(userId)
                .map(existingUser -> {
                    existingUser.setFirstName(updatedUser.getFirstName());
                    existingUser.setLastName(updatedUser.getLastName());
                    existingUser.setEmail(updatedUser.getEmail());
                    existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
                    existingUser.setNationality(updatedUser.getNationality());
                    existingUser.setCountry(updatedUser.getCountry());
                    existingUser.setGovernment(updatedUser.getGovernment());
                    existingUser.setBudget(updatedUser.getBudget());
                    existingUser.setImage(updatedUser.getImage());
                    existingUser.setPreferences(updatedUser.getPreferences());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }*/

    // Delete user account
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    // Get all trips
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    // Get a specific trip by ID
    public Optional<Trip> getTripById(Long tripId) {
        return tripRepository.findById(tripId);
    }
}
