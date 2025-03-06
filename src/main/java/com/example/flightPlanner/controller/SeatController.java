package com.example.flightPlanner.controller;

import com.example.flightPlanner.model.Flight;
import com.example.flightPlanner.model.Seat;
import com.example.flightPlanner.repository.FlightRepository;
import com.example.flightPlanner.service.FlightService;
import com.example.flightPlanner.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/* 
@Controller
@RequestMapping("/seats")
public class SeatController {
    @Autowired
    private SeatService seatService;
    
    @Autowired
    private FlightService flightService;

   /**  @GetMapping("/seatSelection")
    public String selectSeats(@RequestParam("flightId") Integer flightId, Model model) {
        Flight flight = flightService.findFlightById(flightId);
        if (flight == null) {
            return "error"; // Redirect to error page if flight is not found
        }
        model.addAttribute("flight", flight);
        model.addAttribute("availableSeats", seatService.getAvailableSeats(flightId));
        return "seatSelection"; // Ensure this page exists in your templates
    }
        

        @GetMapping("/seatSelection")
        public String selectSeats(@RequestParam("flightId") Integer flightId, Model model) {
            Flight flight = flightService.findFlightById(flightId);
        
            if (flight == null) {
                throw new RuntimeException("Flight with ID " + flightId + " not found!");
            }

            List<Seat> seats = seatService.getSeatsByFlightId(flightId);
        
            model.addAttribute("flight", flight);
            model.addAttribute("seats", seats);
        
            return "seatSelection";
        }

        @PostMapping("/selectSeat")
        @ResponseBody
        public ResponseEntity<String> selectSeat(@RequestParam("seatId") int seatId) {
            boolean success = seatService.occupySeat(seatId);

            if (success) {
                return ResponseEntity.ok("Seat occupied successfully");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Seat selection failed");
            }
        }


        @GetMapping("/seats/seatCount")
public int getSeatCount(@RequestParam("flightId") Integer flightId) {
    return seatService.getSeatCountByFlight(flightId);  // Returns the count of seats for the flight
}
}
*/
   



/* 
@Controller
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/seats/seatSelection")
    public String showAvailableSeats(@RequestParam("flightId") int flightId, Model model) {
        // Fetch available seats from the database for the given flightId
        List<Seat> availableSeats = seatService.getAvailableSeats(flightId);

        // Add the list of available seats to the model
        model.addAttribute("availableSeats", availableSeats);

        // Return the name of the view that will display the available seats
        return "seatSelection";
    }
}
*/

@Controller
public class SeatController {

    @Autowired
    private SeatService seatService;


    @GetMapping("/seats/seatSelection")
    public String showSeats(@RequestParam("flightId") int flightId, Model model) {
        // Fetch all seats (both available and occupied) for the given flightId
        List<Seat> allSeats = seatService.getSeats(flightId);

        // Add the list of seats to the model
        model.addAttribute("allSeats", allSeats);
        model.addAttribute("flightId", flightId);

        // Return the name of the view that will display the seats
        return "seatSelection";
    }

    @PostMapping("/seats/select")
    public String selectSeat(@RequestParam("seatId") int seatId, @RequestParam("flightId") int flightId, Model model) {
        // Select the seat and update its status to occupied
        Seat selectedSeat = seatService.selectSeat(seatId);

        // Reload the seats for the given flightId
        List<Seat> allSeats = seatService.getSeats(flightId);
        model.addAttribute("allSeats", allSeats);
        model.addAttribute("flightId", flightId);

        return "seatSelection"; // Return the same view to show updated status
    }

    /* 
    @GetMapping("/seats/seatSelection")
    public String showAvailableSeats(@RequestParam("flightId") int flightId, Model model) {
        // Fetch available seats from the database for the given flightId
        List<Seat> availableSeats = seatService.getAvailableSeats(flightId);

        // Add the list of available seats to the model
        model.addAttribute("availableSeats", availableSeats);
        model.addAttribute("flightId", flightId);

        // Return the name of the view that will display the available seats
        return "seatSelection";
    }

    @PostMapping("/seats/select")
    public String selectSeat(@RequestParam("seatId") int seatId, @RequestParam("flightId") int flightId, Model model) {
        // Select the seat and update its status to occupied
        Seat selectedSeat = seatService.selectSeat(seatId);

        // Fetch the updated seat details (for confirmation or display)
        model.addAttribute("seatDetails", "Seat Number: " + selectedSeat.getSeatNumber() + 
                             ", Seat Type: " + selectedSeat.getSeatType() + 
                             ", Has Legroom: " + (selectedSeat.isHasLegroom() ? "Yes" : "No") +
                             ", Close to Exit: " + (selectedSeat.isCloseToExit() ? "Yes" : "No"));

        // Reload the available seats for the given flightId
        List<Seat> availableSeats = seatService.getAvailableSeats(flightId);
        model.addAttribute("availableSeats", availableSeats);
        model.addAttribute("flightId", flightId);

        return "seatSelection"; // Return the same view to show updated status
    }
        */
    

}
