package com.notyetdecided.flightcheckin.Integration;

import com.notyetdecided.flightcheckin.DTOs.Reservation;
import com.notyetdecided.flightcheckin.DTOs.ReservationUpdateRequest;

public interface ReservationRestClient {

     Reservation findReservation(long id);
     void updateReservation(ReservationUpdateRequest reservationUpdateRequest);


}
