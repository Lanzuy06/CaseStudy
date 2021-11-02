package com.lanz.flightreservation.services;

import com.lanz.flightreservation.dto.ReservationRequest;
import com.lanz.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
