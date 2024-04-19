package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Venue {
  private String venueName;
  private String venueCode;
  private String capacityInput;
  private String hireFeeInput;
  private ArrayList<Booking> bookingList;

  // Initialising constructor
  public Venue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.capacityInput = capacityInput;
    this.hireFeeInput = hireFeeInput;

    this.bookingList = new ArrayList<>();
  }

  public String getVenueName() {
    return this.venueName;
  }

  public String getVenueCode() {
    return this.venueCode;
  }

  public String getCapacityInput() {
    return this.capacityInput;
  }

  public String getHireFeeInput() {
    return this.hireFeeInput;
  }

  public ArrayList<Booking> getBookingList() {
    return this.bookingList;
  }
}
