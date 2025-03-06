package com.example.flightPlanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FlightViewController {

    @GetMapping("/")
    public String homePage() {
        return "index";  // This will render src/main/resources/templates/index.html
    }
}
