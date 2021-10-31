package com.notyetdecided.flightcheckin.Controllers;

import com.notyetdecided.flightcheckin.DTOs.Reservation;
import com.notyetdecided.flightcheckin.DTOs.ReservationUpdateRequest;
import com.notyetdecided.flightcheckin.Integration.ReservationRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpResponse;

@Controller
public class CheckInController {
    @Autowired
    private ReservationRestClient reservationRestClient;

     @GetMapping ("/showStartCheckInPage")
      public String showStartCheckIn(){
        return "showStartCheckin";
      }

      @RequestMapping("/startCheckIn")
      public String startCheckIn(@RequestParam("reservationId") long id, ModelMap modelMap){
         Reservation reservation= reservationRestClient.findReservation(id);
         modelMap.addAttribute("reservation",reservation);
         return "displayReservationDetails";
      }

      @RequestMapping("/completeCheckIn")
       public  String completeCheckIn(@RequestParam("reservationId") long id, @RequestParam("numberOfBags") int noOfBags,ModelMap modelMap ){
          ReservationUpdateRequest reservationUpdateRequest=new ReservationUpdateRequest();
          reservationUpdateRequest.setCheckedIn(true);
          reservationUpdateRequest.setNoOfBags(noOfBags);
          reservationUpdateRequest.setId(id);
          reservationRestClient.updateReservation(reservationUpdateRequest);
          return "checkInConfirmation";
      }
}
