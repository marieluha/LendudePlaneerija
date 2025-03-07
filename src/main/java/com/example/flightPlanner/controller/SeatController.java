package com.example.flightPlanner.controller;


import com.example.flightPlanner.model.Seat;

import com.example.flightPlanner.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;



@Controller
public class SeatController {

    @Autowired
    private SeatService seatService;


    @GetMapping("/seats/seatSelection")
    public String showSeats(@RequestParam("flightId") int flightId, Model model) {
       
        List<Seat> allSeats = seatService.getSeats(flightId);

        
        model.addAttribute("allSeats", allSeats);
        model.addAttribute("flightId", flightId);

        
        return "seatSelection";
    }

    @PostMapping("/seats/select")
    public String selectSeat(@RequestParam("seatId") int seatId, @RequestParam("flightId") int flightId, Model model) {
       
        Seat selectedSeat = seatService.selectSeat(seatId);

        
        List<Seat> allSeats = seatService.getSeats(flightId);
        model.addAttribute("allSeats", allSeats);
        model.addAttribute("flightId", flightId);

        return "seatSelection"; 
    }
}