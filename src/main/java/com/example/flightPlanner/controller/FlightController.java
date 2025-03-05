package com.example.flightPlanner.controller;

import com.example.flightPlanner.model.Flight;

import com.example.flightPlanner.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public String getAllFlights(Model model) {
        List<Flight> flights = flightService.getAllFlights();
        model.addAttribute("flights", flights);
        return "index"; 
    }


    
    @GetMapping("/search")
    public String searchFlights(
            @RequestParam(value = "destination", required = false) String destination,
            @RequestParam(value = "minPrice", required = false) Double minPrice,
            @RequestParam(value = "maxPrice", required = false) Double maxPrice,
            @RequestParam(value = "startDate", required = false) String startDate,
            @RequestParam(value = "endDate", required = false) String endDate,
            @RequestParam(value = "startTime", required = false) String startTime,
            @RequestParam(value = "endTime", required = false) String endTime,
            Model model) {

        
        List<Flight> flights = flightService.getFilteredFlights(destination, minPrice, maxPrice, startDate, endDate, startTime, endTime);
        model.addAttribute("flights", flights);
        return "index"; 
    }
}
