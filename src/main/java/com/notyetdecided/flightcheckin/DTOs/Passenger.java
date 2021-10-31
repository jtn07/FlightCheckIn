package com.notyetdecided.flightcheckin.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@AllArgsConstructor
@NoArgsConstructor
@Data
public class Passenger   {

    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;
}
