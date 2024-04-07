package nz.ac.auckland.se281;


public class Booking{
  String venueCode;
  String requestedDate;
  String email;
  String attendees;

  public Booking(String venueCode, String requestedDate, String email, String attendees){
    this.venueCode=venueCode;
    this.requestedDate=requestedDate;
    this.email=email;
    this.attendees=attendees;
  }

}