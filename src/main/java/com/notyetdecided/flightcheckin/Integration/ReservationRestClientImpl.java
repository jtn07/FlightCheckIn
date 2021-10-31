package com.notyetdecided.flightcheckin.Integration;

import com.notyetdecided.flightcheckin.DTOs.Reservation;
import com.notyetdecided.flightcheckin.DTOs.ReservationUpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationRestClientImpl implements  ReservationRestClient{

    Logger logger = LoggerFactory.getLogger("ReservationRestClientImpl_logger");
    //@Value("${ReservationRestClientImpl.UPDATEURL}")
    private static String UPDATEURL= "http://localhost:8080/reservations/update/";
            // @Value("${ReservationRestClientImpl.FINDURL}")
    private static String FINDURL= "http://localhost:8080/reservations/";

    @Override
    public Reservation findReservation(long id) {
        RestTemplate restTemplate =new RestTemplate();
        Reservation reservation = restTemplate.getForObject(FINDURL + id, Reservation.class);
        return reservation;
    }

    @Override
    public void updateReservation(ReservationUpdateRequest reservationUpdateRequest) {
        RestTemplate restTemplate =new RestTemplate();
        logger.info("reservationUpdateRequest.getId() "+reservationUpdateRequest.getId());
        logger.info(reservationUpdateRequest.getNoOfBags()+"");
        logger.info(reservationUpdateRequest.isCheckedIn()+"");
       Reservation response =  restTemplate.postForObject(UPDATEURL,reservationUpdateRequest, Reservation.class);
   }
}
