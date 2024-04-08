package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;
import nz.ac.auckland.se281.Venue;
import nz.ac.auckland.se281.Date;
import nz.ac.auckland.se281.Booking;


import java.util.ArrayList;


public class VenueHireSystem {

  //initializes array list for venues to be stored
ArrayList <Venue> venueList;
Date systemDate;



  public VenueHireSystem() {
    //constructor
    venueList = new ArrayList<>();
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
    


    if (venueList.size()==0){
      MessageCli.NO_VENUES.printMessage();
    }
    else if(venueList.size()==1){
      MessageCli.NUMBER_VENUES.printMessage("is", NumberWords.get(venueList.size()-1), "");


      for (Venue IteratorVenue: venueList){
        MessageCli.VENUE_ENTRY.printMessage(IteratorVenue.venueName, IteratorVenue.venueCode, IteratorVenue.capacityInput, IteratorVenue.hireFeeInput );
      }
    }
    else if (1<venueList.size()&& venueList.size()<10){

      MessageCli.NUMBER_VENUES.printMessage("are", NumberWords.get(venueList.size()-1), "s");
      for (Venue IteratorVenue: venueList){
        MessageCli.VENUE_ENTRY.printMessage(IteratorVenue.venueName, IteratorVenue.venueCode, IteratorVenue.capacityInput, IteratorVenue.hireFeeInput );
      }
    }
    else {
      MessageCli.NUMBER_VENUES.printMessage("are",String.valueOf(venueList.size()), "s" );
      for (Venue IteratorVenue: venueList){
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
  public boolean CodeCheck(ArrayList <Venue> venueList, String venueCode, String venueName){
    int count=0;
    for (Venue venue: venueList){
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

    if (NameCheck(venueName) && CodeCheck(venueList, venueCode, venueName) && CapacityChecker(capacityInput) && FeeChecker(hireFeeInput)){
      MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(newVenue.venueName, newVenue.venueCode);
      venueList.add(newVenue);
    }


  }


  //Task 2

  public void setSystemDate(String dateInput) {
    //this.systemDate = dateInput;
    String[] dateParts = dateInput.split("/");
    int day = Integer.parseInt(dateParts[0]);
    int month = Integer.parseInt(dateParts[1]);
    int year = Integer.parseInt(dateParts[2]);
    this.systemDate= new Date(day, month, year, dateInput);

    MessageCli.DATE_SET.printMessage(this.systemDate.stringDate);
  }

  public void printSystemDate() {
    // TODO implement this method

    if (this.systemDate.stringDate.isBlank()){
      MessageCli.CURRENT_DATE.printMessage("not set");
    }
    else {
     MessageCli.CURRENT_DATE.printMessage(this.systemDate.stringDate);
    }
  }


  //Methods for makeBooking method

  

  //Checks if venue is available on inputted date, by checking the booking list for that specific venue.
  public boolean isVenueAvailable(String inputtedDate, String inputtedVenueCode){
    Venue specificVenue;

    int venueIndex=-1;

    //Finding where the venue is located and storing that in the venueindex variable
    for (Venue venue: venueList){
      venueIndex++;
      if (inputtedVenueCode.equals(venue.venueCode)){
        break;
      }
    }

    //Retrieves that specific venue from venueList
    specificVenue=venueList.get(venueIndex);


    //iterates through booking list of the specific venue and finding if that venue is already booked on that specific date
    for (Booking booking: specificVenue.bookingList){

      if (inputtedDate.equals(booking.requestedDate)){

        MessageCli.BOOKING_NOT_MADE_VENUE_ALREADY_BOOKED.printMessage(specificVenue.venueName, inputtedDate);
        return false;
      }
    }
    return true;
  }


  
 


  //Checks if system date is set, returns error message otherwise
  public boolean isSystemDateSet(){
    if (systemDate.stringDate.isBlank()){
      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
      return false;
    }
    return true;
  }



  //Checks if there is more than one venue in the system, by checking size of array list of venues
  public boolean atleastOneVenue(){
    if (venueList.size()<=1){
      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
      return false;
    }
    else{
      return true;
    }
  }

  //Checks if venuecode is present by iterating through venue list, returns true if present, returns error message otherwise 
  public boolean venueCodePresent(String inputtedVenueCode, ArrayList <Venue> venueList){

    
    for (Venue venue: venueList){
      
      if (inputtedVenueCode.equals(venue.venueCode)){
        
        return true;
      }
    }

    MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(inputtedVenueCode);
    return false;
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
    //option[0] is venuecode
    //option[1] is date
    //option[2] is email
    // option[3] is number of attendees
    String[] dateParts = options[1].split("/");
    int day = Integer.parseInt(dateParts[0]);
    int month = Integer.parseInt(dateParts[1]);
    int year = Integer.parseInt(dateParts[2]);
    Date bookingDate = new Date(day, month, year, options[1]);
    boolean a= bookingDate.pastDate(systemDate);


    /*boolean a;
    boolean b;
    boolean c;
    boolean d;
    a=venueCodePresent(options[0], venueList);
    b=atleastOneVenue();
    c=isSystemDateSet();
    d=isVenueAvailable(options[1], options[0]);*/



  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }


  //Task 3
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
