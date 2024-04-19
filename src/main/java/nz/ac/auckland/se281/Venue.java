package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Venue {
  String venueName;
  String venueCode;
  String capacityInput;
  String hireFeeInput;
  ArrayList<Booking> bookingList;

  // Initialising constructor
  public Venue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.capacityInput = capacityInput;
    this.hireFeeInput = hireFeeInput;

    this.bookingList = new ArrayList<>();
  }
}
