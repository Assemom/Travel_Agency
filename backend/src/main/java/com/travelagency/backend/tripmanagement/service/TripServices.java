package com.travelagency.backend.tripmanagement.service;

import com.travelagency.backend.tripmanagement.repository.TripRepository;
import org.springframework.stereotype.Service;

@Service
public class TripServices {
    private final TripRepository tripRepository;

    public TripServices(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }
}
