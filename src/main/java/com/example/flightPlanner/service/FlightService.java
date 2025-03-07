package com.example.flightPlanner.service;

import com.example.flightPlanner.model.Flight;

import com.example.flightPlanner.repository.FlightRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }


    public List<Flight> getFilteredFlights(String destination, Double minPrice, Double maxPrice, String startDate, String endDate, String startTime, String endTime) {
        List<Flight> allFlights = flightRepository.findAll();

        
        if (destination != null && !destination.isEmpty()) {
            allFlights = allFlights.stream()
                .filter(flight -> flight.getDestination().toLowerCase().contains(destination.toLowerCase()))
                .collect(Collectors.toList());
        }

        
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


    public Flight findFlightById(Integer flightId) { 
        return flightRepository.findById(flightId).orElse(null);
    }
}