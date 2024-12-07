package com.travelagency.backend.adminmanagement.controller;

import com.travelagency.backend.adminmanagement.services.AdminServicesTrip;
import com.travelagency.backend.tripmanagement.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/trips")
public class AdminControllerTrip {
    private final AdminServicesTrip adminServicesTrip;

    @Autowired
    public AdminControllerTrip(AdminServicesTrip adminServicesTrip) {
        this.adminServicesTrip = adminServicesTrip;
    }

    // Show all trips
    @GetMapping
    public List<Trip> getAllTrips() {
        return adminServicesTrip.getAllTrips();
    }

    // Show a single trip by ID
    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable Long id) {
        return adminServicesTrip.getTripById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new trip
    @PostMapping
    public Trip createTrip(@RequestBody Trip trip) {
        return adminServicesTrip.saveTrip(trip);
    }

    // Update a trip
    /*@PutMapping("/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Long id, @RequestBody Trip updatedTrip) {
        try {
            return ResponseEntity.ok(adminServicesTrip.updateTrip(id, updatedTrip));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }*/

    // Delete a trip
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Long id) {
        adminServicesTrip.deleteTrip(id);
        return ResponseEntity.noContent().build();
    }
}
