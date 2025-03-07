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
        
        return seatRepository.findByFlightId(flightId);
    }

    public Seat selectSeat(int seatId) {
        
        Seat seat = seatRepository.findById(seatId);

        seat.setOccupied(true);
        seatRepository.save(seat); 

        return seat;
    }
    


    public List<Seat> recommendSeats(Flight flight, int numPassengers) {
        List<Seat> availableSeats = seatRepository.findByFlightAndIsOccupiedFalse(flight);
        return availableSeats.stream().limit(numPassengers).collect(Collectors.toList());
    }


    public List<Seat> getSeatsByFlightId(Integer flightId) {
        return seatRepository.findByFlightId(flightId);
    }


    public int getSeatCountByFlight(Integer flightId) {
        return seatRepository.countSeatsByFlightId(flightId);  
    }

    
}
