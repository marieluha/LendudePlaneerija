package com.example.flightPlanner.repository;


import com.example.flightPlanner.model.Flight;
import com.example.flightPlanner.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

    
    Seat findById(int seatId);

    List<Seat> findByFlightId(Integer flightId);

    List<Seat> findByFlightIdAndIsOccupied(int flightId, boolean isOccupied);


//vist ei toota
    List<Seat> findByFlightAndIsOccupiedFalse(Flight flight);
    
    List<Seat> findByFlightIdAndIsOccupiedFalse(Integer flightId);
    int countSeatsByFlightId(Integer flightId);
    //long countByFlightIdAndIsOccupiedFalse(Integer flightId);
}

