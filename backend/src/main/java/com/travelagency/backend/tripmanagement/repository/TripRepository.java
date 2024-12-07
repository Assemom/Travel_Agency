package com.travelagency.backend.tripmanagement.repository;

import com.travelagency.backend.tripmanagement.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {
}
