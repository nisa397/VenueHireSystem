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

    ArrayList <String> NumberWords= new ArrayList<String>();

    NumberWords.add("one");
    NumberWords.add("two");
    NumberWords.add("three");
    NumberWords.add("four");
    NumberWords.add("five");
    NumberWords.add("six");
    NumberWords.add("seven");
    NumberWords.add("eight");
    NumberWords.add("nine");
    
    //int NoOfVenues=Venues.size();


    if (Venues.size()==0){
      MessageCli.NO_VENUES.printMessage();
    }
    else if(Venues.size()==1){
      MessageCli.NUMBER_VENUES.printMessage("is", NumberWords.get(Venues.size()-1), "");


      for (Venue IteratorVenue: Venues){
        MessageCli.VENUE_ENTRY.printMessage(IteratorVenue.venueName, IteratorVenue.venueCode, IteratorVenue.capacityInput, IteratorVenue.hireFeeInput );
      }
    }
    else if (1<Venues.size()&& Venues.size()<10){

      MessageCli.NUMBER_VENUES.printMessage("are", NumberWords.get(Venues.size()-1), "s");
      for (Venue IteratorVenue: Venues){
        MessageCli.VENUE_ENTRY.printMessage(IteratorVenue.venueName, IteratorVenue.venueCode, IteratorVenue.capacityInput, IteratorVenue.hireFeeInput );
      }
    }
    else {
      MessageCli.NUMBER_VENUES.printMessage("are",String.valueOf(Venues.size()), "s" );
      for (Venue IteratorVenue: Venues){
        MessageCli.VENUE_ENTRY.printMessage(IteratorVenue.venueName, IteratorVenue.venueCode, IteratorVenue.capacityInput, IteratorVenue.hireFeeInput );
      }

    }
  }

  public boolean NameCheck(String venueName){
    if (venueName.trim().isBlank()==true){
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
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
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
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
        return false;
      } 
      
    }


  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // TODO implement this method

    //boolean b,c,d,e;

    
    Venue newVenue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
    
    
   /* b=NameCheck(venueName);
    c=CodeCheck(Venues, venueCode);
    d=CapacityChecker(capacityInput);
    e=FeeChecker(hireFeeInput);

    System.out.println(b);
    System.out.println(c);
    System.out.println(d);
    System.out.println(e);*/

    if (NameCheck(venueName) && CodeCheck(Venues, venueCode) && CapacityChecker(capacityInput) && FeeChecker(hireFeeInput)){
      MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(newVenue.venueName, newVenue.venueCode);
      Venues.add(newVenue);
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
