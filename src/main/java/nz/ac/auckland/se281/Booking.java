package nz.ac.auckland.se281;


public class Booking{
  String venueCode;
  String requestedDate;
  String email;
  String attendees;
  String bookingRef;

  public Booking(String venueCode, String requestedDate, String email, String attendees, String bookingRef){
    this.venueCode=venueCode;
    this.requestedDate=requestedDate;
    this.email=email;
    this.attendees=attendees;
    this.bookingRef=bookingRef;
  }

}