package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;
import nz.ac.auckland.se281.Venue;


import java.util.ArrayList;


public class VenueHireSystem {

  //initializes array list for venues to be stored
ArrayList <Venue> Venues;



  public VenueHireSystem() {
    //constructor
    Venues = new ArrayList<>();
  }

  

  //Utilizes array list to store the the word numbers from one to nine
  //the size method determines which number is printed out to indicate how many venues there are
  // and to indicate whether it is printed in word form or in number form, depening on how many venues there are
  public void printVenues() {

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


  //Checks if Venue name input is empty or not
  //utilizes isblank to check if the inputted venue name is blank or not, and method returns false, and prints otherwise, if it is blank
  //otherwise returns true
  public boolean NameCheck(String venueName){
    if (venueName.trim().isBlank()==true){
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return false;
    }
    else {
      return true;
    }
      
    }

    //Checking if the venue code is unique or not
    //method iterates through arraylist, checking if there is a match between inputted venue code
    // and existing venue codes, and prints error message, and returns false if so
    // if not, then returns true
  public boolean CodeCheck(ArrayList <Venue> Venues, String venueCode, String venueName){
    int count=0;
    for (Venue venue: Venues){
      if (venueCode.equals(venue.venueCode)){
        count++;
        
      }
    }
    if (count==1){
      MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCode, venueName);
      return false;
    }

    return true;
  }  


  //Checks if the capacity input is a word number or an actual number
  //If capacity input is invalid, it returns false, and prints out error message
    //if capacity input is valid, it returns true 
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
    

    //Checks if hire fee input is an actual number and not a word number
    //If hire fee input is invalid, it returns false, and prints out error message
    //if hire fee input is valid, it returns true 
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


    //Constructor for venue instance
    Venue newVenue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
    

    //If all of the inputs are valid, then the venue is added to the system, and the corresponding message is printed out

    if (NameCheck(venueName) && CodeCheck(Venues, venueCode, venueName) && CapacityChecker(capacityInput) && FeeChecker(hireFeeInput)){
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
