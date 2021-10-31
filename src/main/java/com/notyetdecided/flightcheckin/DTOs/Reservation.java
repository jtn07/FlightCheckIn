package com.notyetdecided.flightcheckin.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation  {

    private long id;
    private boolean checkedIn;

    private int noOfBags;

    private Passenger passenger;

    private Flight flight;

}
