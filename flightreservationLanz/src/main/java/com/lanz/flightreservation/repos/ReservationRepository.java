package com.lanz.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lanz.flightreservation.entities.Reservation;
import com.lanz.flightreservation.entities.User;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
