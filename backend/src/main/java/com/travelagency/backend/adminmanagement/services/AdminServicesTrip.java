package com.travelagency.backend.adminmanagement.services;

import com.travelagency.backend.tripmanagement.model.Trip;
import com.travelagency.backend.tripmanagement.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServicesTrip {
    private TripRepository tripRepository;

    public AdminServicesTrip(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    // get all Trip entities from the database.
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }
    // Finds a trip by its ID.
    public Optional<Trip> getTripById(Long id) {
        return tripRepository.findById(id);
    }
    // Saves the Trip object to the database.
    public Trip saveTrip(Trip trip) {
        return tripRepository.save(trip);
    }
    /* If the Trip exists, update its fields with the new values.
    public Trip updateTrip(Long id, Trip updatedTrip) {
        return tripRepository.findById(id)
                .map(existingTrip -> {
                    existingTrip.setTitle(updatedTrip.getTitle());
                    existingTrip.setDescription(updatedTrip.getDescription());
                    existingTrip.setPrice(updatedTrip.getPrice());
                    return tripRepository.save(existingTrip);
                })
                .orElseThrow(() -> new RuntimeException("Trip not found with id: " + id));
    }*/
    //delete trip
    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

}
