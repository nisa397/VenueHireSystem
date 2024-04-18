package nz.ac.auckland.se281;
import java.util.ArrayList;

import nz.ac.auckland.se281.Service;

public class Booking{
  String venueCode;
  String requestedDate;
  String email;
  String attendees;
  String bookingRef;
  ArrayList <Service> servicesList;

  public Booking(String venueCode, String requestedDate, String email, String attendees, String bookingRef){
    this.venueCode=venueCode;
    this.requestedDate=requestedDate;
    this.email=email;
    this.attendees=attendees;
    this.bookingRef=bookingRef;
    servicesList= new ArrayList<Service>();
  }

}