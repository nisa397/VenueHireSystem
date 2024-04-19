package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Booking {
  private String venueCode;
  private String requestedDate;
  private String email;
  private String attendees;
  private String bookingRef;
  private ArrayList<Service> servicesList;
  private String dateOfBooking;

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

  public String getAttendees() {
    return this.attendees;
  }

  public String getBookingRef() {
    return this.bookingRef;
  }

  public String getDateOfBooking() {
    return this.dateOfBooking;
  }

  public String getEmail() {
    return this.email;
  }

  public String getRequestedDate() {
    return this.requestedDate;
  }

  public ArrayList<Service> getServicesList() {
    return this.servicesList;
  }

  public String getVenueCode() {
    return this.venueCode;
  }
}
