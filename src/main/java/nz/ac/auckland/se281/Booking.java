package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Booking {
  String venueCode;
  String requestedDate;
  String email;
  String attendees;
  String bookingRef;
  ArrayList<Service> servicesList;
  String dateOfBooking;

  public Booking(
      String venueCode,
      String requestedDate,
      String email,
      String attendees,
      String bookingRef,
      String dateOfBooking) {
    this.venueCode = venueCode;
    this.requestedDate = requestedDate;
    this.dateOfBooking = dateOfBooking;
    this.email = email;
    this.attendees = attendees;
    this.bookingRef = bookingRef;
    // Service list has all services added to it
    servicesList = new ArrayList<Service>();
  }
}
