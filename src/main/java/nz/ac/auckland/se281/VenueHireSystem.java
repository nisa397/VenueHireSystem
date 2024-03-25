package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;
import nz.ac.auckland.se281.Venue;


import java.util.ArrayList;


public class VenueHireSystem {

ArrayList <Venue> Venues;


  public VenueHireSystem() {
    Venues = new ArrayList<>();
  }

  

  public void printVenues() {
    // TODO implement this method
   
  }

  public boolean NameCheck(String venueName){
    if (venueName.isBlank()==true){
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return false;
    }
    else {
      return true;
    }
      
    }



  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // TODO implement this method

    boolean b;

    Venue newVenue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
    
    
    
    b=NameCheck(venueName);

    System.out.println(b);

    Venues.add(newVenue);

    for (Venue venue : Venues) {
      System.out.println("Venue Name: " + venue.venueName);
      System.out.println();
  }
  
  }

  public void setSystemDate(String dateInput) {
    // TODO implement this method
  }

  public void printSystemDate() {
    // TODO implement this method
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // TODO implement this method
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
