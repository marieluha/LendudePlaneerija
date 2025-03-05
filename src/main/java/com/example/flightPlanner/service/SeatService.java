package com.example.flightPlanner.service;


import com.example.flightPlanner.model.Seat;
import com.example.flightPlanner.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getSeats(Integer flightId) {
        return seatRepository.findByFlightId(flightId);
    }
}