package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;
import nz.ac.auckland.se281.Venue;
import nz.ac.auckland.se281.Date;
import nz.ac.auckland.se281.Booking;
import nz.ac.auckland.se281.Service;
import nz.ac.auckland.se281.CateringService;
import nz.ac.auckland.se281.MusicService;
import nz.ac.auckland.se281.FloralService;

import java.util.ArrayList;


public class VenueHireSystem {

//initializes array list for venues to be stored
ArrayList <Venue> venueList;
//initializes booking list for all bookings created, not accounting for bookings made to a specific venue
ArrayList <Booking> allBookings;
//Initializes system date to prevent exceptions
Date systemDate= new Date(0, 0, 0, "");



  public VenueHireSystem() {
    //constructor, creates new venueList and bookingList everytime it is constructed
    venueList = new ArrayList<>();
    allBookings= new ArrayList<>();
  }
  
  //Retrieves specific venue to be used in relevant methods
  public Venue getSpecificVenue(String venueCode, ArrayList<Venue> venueList){

    Venue specificVenue;

    //Initializing venue index to -1 so it doesn't exceed bounds when iterating
    int venueIndex=-1;

    //Finding where the venue is located and storing that in the venueindex variable
    for (Venue venue: venueList){
      venueIndex++;
      if (venueCode.equals(venue.venueCode)){
        //Breaks out of loop as we got the index we want
        break;
      }
    }

    //Retrieves that specific venue from venueList
    specificVenue=venueList.get(venueIndex);

    return specificVenue;
  }

  //Retrieves specific booking for relevant methods
  public Booking getSpecificBooking(String bookingRef, ArrayList<Booking> allBookings){
    Booking specificBooking;
    //Initializing booking index to -1 so it doesn't exceed bounds when iterating
    int bookingIndex=-1;
    //Finding where the booking is located and storing that in the bookingindex variable
    for (Booking booking : allBookings) {
      bookingIndex++;
      if (bookingRef.equals(booking.bookingRef)){
        break;
      }
    }
    //Retrieves that specific booking from bookingList
    specificBooking=allBookings.get(bookingIndex);
    return specificBooking;
  }

 
  public void printVenues() {
    
    //Utilizes array list to store the the word numbers from one to nine
    ArrayList <String> numberWords= new ArrayList<String>();
    numberWords.add("one");
    numberWords.add("two");
    numberWords.add("three");
    numberWords.add("four");
    numberWords.add("five");
    numberWords.add("six");
    numberWords.add("seven");
    numberWords.add("eight");
    numberWords.add("nine");

    //the size method determines which number is printed out to indicate how many venues there are
    // and to indicate whether it is printed in word form or in number form, depening on how many venues there are
    
    if (venueList.size()==0){
      MessageCli.NO_VENUES.printMessage();
    }
    //accounts for only one venue in the system, prints "there is one venue" instead of there are one venues
    else if(venueList.size()==1){
      MessageCli.NUMBER_VENUES.printMessage("is", numberWords.get(venueList.size()-1), "");

      //Accesses instance fields of venue
      for (Venue iteratorVenue: venueList){
        MessageCli.VENUE_ENTRY.printMessage(iteratorVenue.venueName, iteratorVenue.venueCode, iteratorVenue.capacityInput, iteratorVenue.hireFeeInput, nextAvailableDate(iteratorVenue) );
      }
    }
    //if there is between 1 and 10 venues in the system, it will print the number as a word
    else if (1<venueList.size()&& venueList.size()<10){

      MessageCli.NUMBER_VENUES.printMessage("are", numberWords.get(venueList.size()-1), "s");
      for (Venue iteratorVenue: venueList){
        MessageCli.VENUE_ENTRY.printMessage(iteratorVenue.venueName, iteratorVenue.venueCode, iteratorVenue.capacityInput, iteratorVenue.hireFeeInput, nextAvailableDate(iteratorVenue) );
      }
    }
    //If there is more than 10 venues in the system, prints the number as a digit and not a word
    else {
      MessageCli.NUMBER_VENUES.printMessage("are",String.valueOf(venueList.size()), "s" );
      for (Venue iteratorVenue: venueList){
        MessageCli.VENUE_ENTRY.printMessage(iteratorVenue.venueName, iteratorVenue.venueCode, iteratorVenue.capacityInput, iteratorVenue.hireFeeInput, nextAvailableDate(iteratorVenue) );
      }

    }
  }


  //Checks if Venue name input is empty or not
  //utilizes isblank to check if the inputted venue name is blank or not, and method returns false, and prints otherwise, if it is blank
  //otherwise returns true
  public boolean nameCheck(String venueName){
    if (venueName.trim().isBlank()==true){
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return false;
    }
    else {
      return true;
    }
      
    }

    //Checking if the venue code is unique or not
  public boolean codeCheck(ArrayList <Venue> venueList, String venueCode, String venueName){
    int count=0;
    //method iterates through arraylist, checking if there is a match between inputted venue code
    //and existing venue codes
    for (Venue venue: venueList){
      if (venueCode.equals(venue.venueCode)){
        count++;
        
      }
    }
    
    //prints error message, and returns false if so
    if (count==1){
      MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(venueCode, venueName);
      return false;
    }
    //otherwise true
    return true;
  }  


  //Checks if the capacity input is a word number or an actual number
  public boolean capacityChecker(String capacityInput){
    
    boolean isValid=false;
    int capacityInt=0;
    //if capacity input is valid, it returns true
    try{
      capacityInt=Integer.parseInt(capacityInput);
      
      isValid= true;
    }
     //Accounts for exception if the number is in word form or a word is inputted
    catch(NumberFormatException e){

    }
    if (isValid && capacityInt>=0){
      return true;
    }
    //If capacity input is invalid, it returns false, and prints out error message
    else {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
      return false;
    } 
    }
    

  //Checks if hire fee input is an actual number and not a word number
    
  public boolean feeChecker(String hireFeeInput){
      boolean isValid=false;
      int hireFeeInt=0;
      //if hire fee input is valid, it returns true 
      try{
        hireFeeInt=Integer.parseInt(hireFeeInput);
        
        isValid= true;
      }
      catch(NumberFormatException e){

      }

      if (isValid && hireFeeInt>=0){
        return true;
      }
      //If hire fee input is invalid, it returns false, and prints out error message
      else {
        MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
        return false;
      } 
      
    }

  //Creates a new venue, first checking if venueName isn't empty,
  // venuecode isn't already present, and if hirefee and capacityinput is digits 
  // and not negative
  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {


    //Constructor for venue instance
    Venue newVenue = new Venue(venueName, venueCode, capacityInput, hireFeeInput);
    

    //If all of the inputs are valid, then the venue is added to the system, by adding it to the array list,
    // and the corresponding message is printed out

    if (nameCheck(venueName) && codeCheck(venueList, venueCode, venueName) && capacityChecker(capacityInput) && feeChecker(hireFeeInput)){
      MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(newVenue.venueName, newVenue.venueCode);
      venueList.add(newVenue);
    }


  }


  //Task 2

  public void setSystemDate(String dateInput) {
    

    //Splits system date and converts it to int to be stored as instance fields for the systemDate instance
    String[] dateParts = dateInput.split("/");
    this.systemDate.day = Integer.parseInt(dateParts[0]);
    this.systemDate.month = Integer.parseInt(dateParts[1]);
    this.systemDate.year = Integer.parseInt(dateParts[2]);
    //Adds it as a string, for when it is required as a string
    this.systemDate.stringDate = dateInput;
    

    MessageCli.DATE_SET.printMessage(this.systemDate.stringDate);
  }

  public void printSystemDate() {
  
    //checks if systemDate is not set
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

    //Retrieving the specific venue we want
    specificVenue=getSpecificVenue(inputtedVenueCode, venueList);
    
    

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
    if (venueList.size()==0){
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


  public String nextAvailableDate(Venue venue){
    //Sets available date to the system date
    String availableDate = systemDate.stringDate;
    //Checks if the booking list size is greater than 0
    if (venue.bookingList.size()>0){
      //Checks for when the next available date is, by seeing if the current available date is the same 
      //as any of the current booking dates
      for (Booking booking: venue.bookingList){
        if (availableDate.equals(booking.requestedDate)){
          //if this is the case it will add 1 to the date
          String[] dateParts = availableDate.split("/");
          int intDay=Integer.parseInt(dateParts[0]) + 1;
          //Adds the 0 in front of the date if the day is less than 10
          if (intDay<10){
            String stringDay="0"+Integer.toString(intDay);
            availableDate= stringDay + "/" + dateParts[1] + "/"+ dateParts[2];
          }
          //Converts to string
          else {
            String stringDay=Integer.toString(intDay);
            availableDate= stringDay + "/" + dateParts[1] + "/"+ dateParts[2];
          }
         
          

        }
      }
    }

    return availableDate;
  }



  public void makeBooking(String[] options) {


    
    //option[0] is venuecode
    //option[1] is date
    //option[2] is email
    // option[3] is number of attendees

    Venue specificVenue;

    

    

    //Splitting the inputted date, changing it to int and creating a date instance
    String[] dateParts = options[1].split("/");
    int day = Integer.parseInt(dateParts[0]);
    int month = Integer.parseInt(dateParts[1]);
    int year = Integer.parseInt(dateParts[2]);
    Date bookingDate = new Date(day, month, year, options[1]);

    if (isSystemDateSet() && atleastOneVenue() && venueCodePresent(options[0], venueList) && bookingDate.pastDate(systemDate) && isVenueAvailable(options[1], options[0]) ){
    //Gets specific venue with specificVenueMethod
    specificVenue=getSpecificVenue(options[0], venueList);

    //Stores originial attendees to be used later
    String originAttendees=options[3];
    //If attendees is greater than capacity
    if (Integer.parseInt(options[3])>Integer.parseInt(specificVenue.capacityInput)){

     options[3]=specificVenue.capacityInput;
     MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(originAttendees, options[3], specificVenue.capacityInput);
    }
    //if attendees is less than 25% of capacity, set attendees to be 25% of venue capacity

    else if (Integer.parseInt(options[3])< 0.25 * (Integer.parseInt(specificVenue.capacityInput))){
      //Finding 25% of capacity, and casting it as int
      int capacity25 = (int) (0.25 * (Integer.parseInt(specificVenue.capacityInput)));
      
      options[3]=Integer.toString(capacity25);
      MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(originAttendees, options[3], specificVenue.capacityInput); 
    }

    //Constructs the booking since all conditions are true, also including date of booking in constructor
    Booking newBooking = new Booking(options[0], options[1], options[2], options[3], BookingReferenceGenerator.generateBookingReference(), this.systemDate.stringDate);
    //Adds booking to a list that includes all bookings irregardless of venue
    allBookings.add(newBooking);
    //Adds booking to a booking list specific to that venue
    specificVenue.bookingList.add(newBooking);
    
    MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(newBooking.bookingRef, specificVenue.venueName,options[1], options[3]);
    }
    



  }

  public void printBookings(String venueCode) {


    //initializing variables
    Venue specificVenue;
    int venueIndex=-1;
    boolean venuePresent=false;

    //Finding where the venue is located and storing that in the venueIndex variable
    for (Venue venue : venueList) {
      venueIndex++;
      if (venueCode.equals(venue.venueCode)){
        venuePresent=true;
        break;
        
        

      }
    }
    
    if (venuePresent){
      //Retrieves that specific venue from venueList
      specificVenue=venueList.get(venueIndex);
      //If booking list is empty
      if (specificVenue.bookingList.size()>0){
        //Prints each booking made in that specific venue if there is more than one booking
        for (Booking booking: specificVenue.bookingList) {
          MessageCli.PRINT_BOOKINGS_HEADER.printMessage(specificVenue.venueName);
          MessageCli.PRINT_BOOKINGS_ENTRY.printMessage(booking.bookingRef, booking.requestedDate);
        }
      }
      //no bookings
      else{
        MessageCli.PRINT_BOOKINGS_HEADER.printMessage(specificVenue.venueName);
        MessageCli.PRINT_BOOKINGS_NONE.printMessage(specificVenue.venueName);


      }
    }
    //no venue of that venuecode
    else {
      MessageCli.PRINT_BOOKINGS_VENUE_NOT_FOUND.printMessage(venueCode);
    }



  }


  //Task 3

  //Checks if that booking reference exists
  public boolean doesRefExist(ArrayList <Booking> allBookings, String inpBookingRef){

    for (Booking booking: allBookings){

      if (booking.bookingRef.equals(inpBookingRef)){
        return true;

      }
    }

    return false;
  }


  public void addCateringService(String bookingReference, CateringType cateringType) {

    //Checks if reference exists within all the bookings 
    if (doesRefExist(allBookings, bookingReference)){
      //accesseses the specific booking of the inputted boooking reference from the booking list
      Booking specificBooking=getSpecificBooking(bookingReference, allBookings);
      //Converts attendees parameter in booking class from string to integer
      int intAttendees = Integer.parseInt(specificBooking.attendees);
      //Constructs catering service
      CateringService catering= new CateringService(intAttendees, cateringType, "Catering");
      //Adds catering service to services list within the specific booking
      specificBooking.servicesList.add(catering);
      //Gets specific type of catering that was inputted, to be included in the message
      MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage("Catering "+"("+cateringType.getName()+")", bookingReference);
    }
    else{
      //if booking is not found..
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Catering", bookingReference);
    }
    
  }

  public void addServiceMusic(String bookingReference) {
    ////Checks if reference exists within all the bookings  
    if (doesRefExist(allBookings, bookingReference)){
       //accesseses the specific booking of the inputted boooking reference from the booking list
      Booking specificBooking=getSpecificBooking(bookingReference, allBookings);
      //Constructs music service and adds it to service list within booking
      MusicService music= new MusicService("Music");
      specificBooking.servicesList.add(music);
      //Prints successful message
      MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage("Music", bookingReference);
    }
    else {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Music", bookingReference);
    }
   
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    ////Checks if reference exists within all the bookings
    if (doesRefExist(allBookings, bookingReference)){
       //accesseses the specific booking of the inputted boooking reference from the booking list
      Booking specificBooking=getSpecificBooking(bookingReference, allBookings);
      //Constructs floral service and adds it to service list in specific booking
      FloralService floral = new FloralService(floralType, "Floral");

      specificBooking.servicesList.add(floral);
      MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage("Floral "+"("+floralType.getName()+")",bookingReference);
    }
    else{
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Floral", bookingReference);
    }
    

  }

  public void viewInvoice(String bookingReference) {
    //Initializing cost, to account for exceptions
    int cost=0;
    if (doesRefExist(allBookings, bookingReference)){
      
      Booking specificBooking=getSpecificBooking(bookingReference, allBookings);
      Venue specificVenue=getSpecificVenue(specificBooking.venueCode, venueList);
      //Top half of invoice
      MessageCli.INVOICE_CONTENT_TOP_HALF.printMessage(bookingReference, specificBooking.email, specificBooking.dateOfBooking, specificBooking.requestedDate, specificBooking.attendees, specificVenue.venueName);
      //converting venue fee to int and adding it to cost
      cost=Integer.parseInt(specificVenue.hireFeeInput);

      //Cost Breakdown
      MessageCli.INVOICE_CONTENT_VENUE_FEE.printMessage(specificVenue.hireFeeInput);
      //Iterates through service list of specific booking checking which services are present, and adding the cost if it is present
      for (Service service: specificBooking.servicesList){
        //Checks if the iterated service is an instance of either of the services
        if (service instanceof CateringService){
          //Calculating cost of specific service utilzing the method specific to this service
          cost += service.calculatingCost();
          //Downcasting service instance to CateringService instance to retrieve CateringService instance fields
          CateringService catering= (CateringService) service;
          MessageCli.INVOICE_CONTENT_CATERING_ENTRY.printMessage(catering.getCateringType().getName(),Integer.toString(service.calculatingCost()));
        }
        else if (service instanceof MusicService){
          //Calculating cost of specific service utilzing the method specific to this service
          cost +=service.calculatingCost();
          MessageCli.INVOICE_CONTENT_MUSIC_ENTRY.printMessage(Integer.toString(service.calculatingCost()));
        }
        else if (service instanceof FloralService){
          //Calculating cost of specific service utilzing the method specific to this service
          cost +=service.calculatingCost();
          //Downcasting service instance to service instance to retrieve FloralService instance fields
          FloralService floral= (FloralService) service;
          MessageCli.INVOICE_CONTENT_FLORAL_ENTRY.printMessage(floral.getFloralType().getName(), Integer.toString(service.calculatingCost()));
        }
      }
      MessageCli.INVOICE_CONTENT_BOTTOM_HALF.printMessage(Integer.toString(cost));
    }
    else {
      MessageCli.VIEW_INVOICE_BOOKING_NOT_FOUND.printMessage(bookingReference);
    }
    
  }
}
