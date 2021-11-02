package com.lanz.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lanz.flightreservation.entities.Passenger;
import com.lanz.flightreservation.entities.User;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
