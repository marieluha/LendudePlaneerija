package com.example.flightPlanner.service;

import com.example.flightPlanner.model.Flight;
import com.example.flightPlanner.model.Seat;
import com.example.flightPlanner.repository.FlightRepository;
import com.example.flightPlanner.repository.SeatRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private SeatRepository seatRepository;

    // Method to fetch all flights from the database
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    // Method to filter flights by destination and price range
    public List<Flight> getFilteredFlights(String destination, Double minPrice, Double maxPrice, String startDate, String endDate, String startTime, String endTime) {
        List<Flight> allFlights = flightRepository.findAll();

        // Filter flights based on destination (if provided)
        if (destination != null && !destination.isEmpty()) {
            allFlights = allFlights.stream()
                .filter(flight -> flight.getDestination().toLowerCase().contains(destination.toLowerCase()))
                .collect(Collectors.toList());
        }

        // Filter flights based on price range (if provided)
        if (minPrice != null) {
            allFlights = allFlights.stream()
                .filter(flight -> flight.getPrice() >= minPrice)
                .collect(Collectors.toList());
        }

        if (maxPrice != null) {
            allFlights = allFlights.stream()
                .filter(flight -> flight.getPrice() <= maxPrice)
                .collect(Collectors.toList());
        }

        // Filter by date range
        if (startDate != null && !startDate.isEmpty()) {
            LocalDate start = LocalDate.parse(startDate);
            allFlights = allFlights.stream()
                .filter(flight -> flight.getFlightDate().isAfter(start) || flight.getFlightDate().isEqual(start))
                .collect(Collectors.toList());
        }

        if (endDate != null && !endDate.isEmpty()) {
            LocalDate end = LocalDate.parse(endDate);
            allFlights = allFlights.stream()
                .filter(flight -> flight.getFlightDate().isBefore(end) || flight.getFlightDate().isEqual(end))
                .collect(Collectors.toList());
        }

        // Filter by time range
        if (startTime != null && !startTime.isEmpty()) {
            LocalTime start = LocalTime.parse(startTime);
            allFlights = allFlights.stream()
                .filter(flight -> flight.getFlightTime().isAfter(start) || flight.getFlightTime().equals(start))
                .collect(Collectors.toList());
        }

        if (endTime != null && !endTime.isEmpty()) {
            LocalTime end = LocalTime.parse(endTime);
            allFlights = allFlights.stream()
                .filter(flight -> flight.getFlightTime().isBefore(end) || flight.getFlightTime().equals(end))
                .collect(Collectors.toList());
        }

        

        return allFlights;
    }


    public Flight findFlightById(Integer flightId) { // Changed Long to Integer
        return flightRepository.findById(flightId).orElse(null);
    }

}
