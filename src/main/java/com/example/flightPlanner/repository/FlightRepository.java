package com.example.flightPlanner.repository;

import com.example.flightPlanner.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

}
