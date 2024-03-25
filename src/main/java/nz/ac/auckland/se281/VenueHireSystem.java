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

    //Checking if the venue code is valid
  public boolean CodeCheck(ArrayList <Venue> Venues, String venueCode){
    int count=0;
    for (Venue venue: Venues){
      System.out.println(venue.venueCode);
      if (venueCode.equals(venue.venueCode)){
        count++;
        
      }
    }


    if (count==1){
      MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage();
      return false;
    }

    return true;
  }  


  public boolean CapacityChecker(String capacityInput){

    boolean isValid=false;
    int CapacityInt=0;
    try{
      CapacityInt=Integer.parseInt(capacityInput);
      
      isValid= true;
    }
    catch(NumberFormatException e){

    }

    if (isValid && CapacityInt>=0){
      return true;
    }
    else {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage();
      return false;
    } 
    }
    

    public boolean FeeChecker(String hireFeeInput){
      boolean isValid=false;
      int hireFeeInt=0;
      try{
        hireFeeInt=Integer.parseInt(hireFeeInput);
        
        isValid= true;
      }
      catch(NumberFormatException e){

      }

      if (isValid && hireFeeInt>=0){
        return true;
      }
      else {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage();
        return false;
      } 
      
    }


  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // TODO implement this method

    boolean b,c,d;

    
    Venue newVenue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
    
    
    b=NameCheck(venueName);
    c=CodeCheck(Venues, venueCode);
    d=CapacityChecker(capacityInput);

    System.out.println(b);
    System.out.println(c);
    System.out.println(d);


    Venues.add(newVenue);

    
  
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
