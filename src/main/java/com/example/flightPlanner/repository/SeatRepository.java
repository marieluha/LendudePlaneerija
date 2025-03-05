package com.example.flightPlanner.repository;


import com.example.flightPlanner.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

    
    Seat findById(int seatId);

    List<Seat> findByFlightId(Integer flightId);
}