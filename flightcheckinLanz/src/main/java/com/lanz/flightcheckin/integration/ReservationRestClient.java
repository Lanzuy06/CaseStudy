package com.lanz.flightcheckin.integration;

import com.lanz.flightcheckin.integration.dto.Reservation;
import com.lanz.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

public Reservation findReservation(Long id);

public Reservation updateReservation(ReservationUpdateRequest request);
}
