package com.example.flightPlanner.service;

import com.example.flightPlanner.model.Flight;
import com.example.flightPlanner.model.Seat;
import com.example.flightPlanner.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getSeats(Integer flightId) {
        // Fetch all seats for the given flightId, both available and occupied
        return seatRepository.findByFlightId(flightId);
    }

    public Seat selectSeat(int seatId) {
        // Find the seat by its ID
        Seat seat = seatRepository.findById(seatId);

        // Update the seat status to occupied
        seat.setOccupied(true);
        seatRepository.save(seat); // Save the updated seat

        return seat;
    }
    
/* 
    public List<Seat> getAvailableSeats(Integer flightId) {
        // Fetch the available seats (not occupied) for the given flightId
        return seatRepository.findByFlightIdAndIsOccupied(flightId, false);
    }

    public Seat selectSeat(int seatId) {
        // Find the seat by its ID
        Seat seat = seatRepository.findById(seatId);

        // Update the seat status to occupied
        seat.setOccupied(true);
        seatRepository.save(seat); // Save the updated seat

        return seat;
    }

*/










    public List<Seat> recommendSeats(Flight flight, int numPassengers) {
        List<Seat> availableSeats = seatRepository.findByFlightAndIsOccupiedFalse(flight);
        return availableSeats.stream().limit(numPassengers).collect(Collectors.toList());
    }


    public List<Seat> getSeatsByFlightId(Integer flightId) {
        return seatRepository.findByFlightId(flightId);
    }


    public int getSeatCountByFlight(Integer flightId) {
        // Assuming SeatRepository has a method to count seats for a specific flight
        return seatRepository.countSeatsByFlightId(flightId);  // Return the count of seats for the flight
    }

    
}
