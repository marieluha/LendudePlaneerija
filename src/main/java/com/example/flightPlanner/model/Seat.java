package com.example.flightPlanner.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn; 
import jakarta.persistence.Table;

@Entity
@Table(name = "SEAT")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    
    @ManyToOne
    @JoinColumn(name = "FLIGHT_ID") 
    private Flight flight;  

    @Column(name = "SEAT_NUMBER")
    private String seatNumber;  

    @Column(name = "SEAT_TYPE")
    private String seatType;  

    @Column(name = "HAS_LEGROOM")
    private boolean hasLegroom;  

    @Column(name = "IS_CLOSE_TO_EXIT")
    private boolean isCloseToExit;  

    @Column(name = "IS_OCCUPIED")
    private boolean isOccupied;  

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public boolean isHasLegroom() {
        return hasLegroom;
    }

    public void setHasLegroom(boolean hasLegroom) {
        this.hasLegroom = hasLegroom;
    }

    public boolean isCloseToExit() {
        return isCloseToExit;
    }

    public void setCloseToExit(boolean isCloseToExit) {
        this.isCloseToExit = isCloseToExit;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }
}
