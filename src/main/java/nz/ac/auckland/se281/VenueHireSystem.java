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
ArrayList <Booking> allBookings;
Date systemDate= new Date(0, 0, 0, "");



  public VenueHireSystem() {
    //constructor
    venueList = new ArrayList<>();
    allBookings= new ArrayList<>();
  }
  
  
  public Venue getSpecificVenue(String venueCode, ArrayList<Venue> venueList){

    Venue specificVenue;

    int venueIndex=-1;

    //Finding where the venue is located and storing that in the venueindex variable
    for (Venue venue: venueList){
      venueIndex++;
      if (venueCode.equals(venue.venueCode)){
        break;
      }
    }

    //Retrieves that specific venue from venueList
    specificVenue=venueList.get(venueIndex);

    return specificVenue;
  }

  public Booking getSpecificBooking(String bookingRef, ArrayList<Booking> allBookings){
    Booking specificBooking;

    int bookingIndex=-1;
    for (Booking booking : allBookings) {
      bookingIndex++;
      if (bookingRef.equals(booking.bookingRef)){
        break;
      }
    }
    specificBooking=allBookings.get(bookingIndex);
    return specificBooking;
  }

  //Utilizes array list to store the the word numbers from one to nine
  //the size method determines which number is printed out to indicate how many venues there are
  // and to indicate whether it is printed in word form or in number form, depening on how many venues there are
  public void printVenues() {

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
    


    if (venueList.size()==0){
      MessageCli.NO_VENUES.printMessage();
    }
    else if(venueList.size()==1){
      MessageCli.NUMBER_VENUES.printMessage("is", numberWords.get(venueList.size()-1), "");


      for (Venue iteratorVenue: venueList){
        MessageCli.VENUE_ENTRY.printMessage(iteratorVenue.venueName, iteratorVenue.venueCode, iteratorVenue.capacityInput, iteratorVenue.hireFeeInput, nextAvailableDate(iteratorVenue) );
      }
    }
    else if (1<venueList.size()&& venueList.size()<10){

      MessageCli.NUMBER_VENUES.printMessage("are", numberWords.get(venueList.size()-1), "s");
      for (Venue iteratorVenue: venueList){
        MessageCli.VENUE_ENTRY.printMessage(iteratorVenue.venueName, iteratorVenue.venueCode, iteratorVenue.capacityInput, iteratorVenue.hireFeeInput, nextAvailableDate(iteratorVenue) );
      }
    }
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
    //method iterates through arraylist, checking if there is a match between inputted venue code
    // and existing venue codes, and prints error message, and returns false if so
    // if not, then returns true
  public boolean codeCheck(ArrayList <Venue> venueList, String venueCode, String venueName){
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
  public boolean capacityChecker(String capacityInput){

    boolean isValid=false;
    int capacityInt=0;
    try{
      capacityInt=Integer.parseInt(capacityInput);
      
      isValid= true;
    }
    catch(NumberFormatException e){

    }

    if (isValid && capacityInt>=0){
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
  public boolean feeChecker(String hireFeeInput){
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

    if (nameCheck(venueName) && codeCheck(venueList, venueCode, venueName) && capacityChecker(capacityInput) && feeChecker(hireFeeInput)){
      MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(newVenue.venueName, newVenue.venueCode);
      venueList.add(newVenue);
    }


  }


  //Task 2

  public void setSystemDate(String dateInput) {
    

    //this.systemDate = dateInput;
    String[] dateParts = dateInput.split("/");
    this.systemDate.day = Integer.parseInt(dateParts[0]);
    this.systemDate.month = Integer.parseInt(dateParts[1]);
    this.systemDate.year = Integer.parseInt(dateParts[2]);
    this.systemDate.stringDate = dateInput;
    //this.systemDate= new Date(day, month, year, dateInput);

    MessageCli.DATE_SET.printMessage(this.systemDate.stringDate);
  }

  public void printSystemDate() {
  

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
    String availableDate = systemDate.stringDate;
    if (venue.bookingList.size()>0){
      for (Booking booking: venue.bookingList){
        if (availableDate.equals(booking.requestedDate)){

          String[] dateParts = availableDate.split("/");
          int intDay=Integer.parseInt(dateParts[0]) + 1;
          if (intDay<10){
            String stringDay="0"+Integer.toString(intDay);
            availableDate= stringDay + "/" + dateParts[1] + "/"+ dateParts[2];
          }
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

    int venueIndex=-1;

    

    //Splitting the inputted date, changing it to int and creating a date instance
    String[] dateParts = options[1].split("/");
    int day = Integer.parseInt(dateParts[0]);
    int month = Integer.parseInt(dateParts[1]);
    int year = Integer.parseInt(dateParts[2]);
    Date bookingDate = new Date(day, month, year, options[1]);

    if (isSystemDateSet() && atleastOneVenue() && venueCodePresent(options[0], venueList) && bookingDate.pastDate(systemDate) && isVenueAvailable(options[1], options[0]) ){
      //Finding where the venue is located and storing that in the venueindex variable
      for (Venue venue: venueList){
      venueIndex++;
      if (options[0].equals(venue.venueCode)){
        break;
      }
    }

    //Retrieves that specific venue from venueList
    specificVenue=venueList.get(venueIndex);

    String originAttendees=options[3];
    //If attendees is greater than capacity
    if (Integer.parseInt(options[3])>Integer.parseInt(specificVenue.capacityInput)){

     options[3]=specificVenue.capacityInput;
     MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(originAttendees, options[3], specificVenue.capacityInput);
    }
    //if attendees is less than 25% of capacity

    else if (Integer.parseInt(options[3])< 0.25 * (Integer.parseInt(specificVenue.capacityInput))){
      int capacity25 = (int) (0.25 * (Integer.parseInt(specificVenue.capacityInput)));
      
      options[3]=Integer.toString(capacity25);
      MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(originAttendees, options[3], specificVenue.capacityInput); 
    }
    Booking newBooking = new Booking(options[0], options[1], options[2], options[3], BookingReferenceGenerator.generateBookingReference(), this.systemDate.stringDate);
    allBookings.add(newBooking);
    specificVenue.bookingList.add(newBooking);
    
    MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(newBooking.bookingRef, specificVenue.venueName,options[1], options[3]);
    }
    



  }

  public void printBookings(String venueCode) {

    Venue specificVenue;
    int venueIndex=-1;
    boolean venuePresent=false;


    for (Venue venue : venueList) {
      venueIndex++;
      if (venueCode.equals(venue.venueCode)){
        venuePresent=true;
        break;
        //Finding where the venue is located and storing that in the venueIndex variable
        //Retrieves that specific venue from venueList
        

      }
    }
    
    if (venuePresent){
      specificVenue=venueList.get(venueIndex);
      if (specificVenue.bookingList.size()>0){
        for (Booking booking: specificVenue.bookingList) {
          MessageCli.PRINT_BOOKINGS_HEADER.printMessage(specificVenue.venueName);
          MessageCli.PRINT_BOOKINGS_ENTRY.printMessage(booking.bookingRef, booking.requestedDate);
        }

      }
      else{
        MessageCli.PRINT_BOOKINGS_HEADER.printMessage(specificVenue.venueName);
        MessageCli.PRINT_BOOKINGS_NONE.printMessage(specificVenue.venueName);


      }
    }
    else {
      MessageCli.PRINT_BOOKINGS_VENUE_NOT_FOUND.printMessage(venueCode);
    }



  }


  //Task 3


  public boolean doesRefExist(ArrayList <Booking> allBookings, String inpBookingRef){

    for (Booking booking: allBookings){

      if (booking.bookingRef.equals(inpBookingRef)){
        return true;

      }
    }

    return false;
  }


  public void addCateringService(String bookingReference, CateringType cateringType) {

    if (doesRefExist(allBookings, bookingReference)){
      Booking specificBooking=getSpecificBooking(bookingReference, allBookings);
      int intAttendees = Integer.parseInt(specificBooking.attendees);
      CateringService catering= new CateringService(intAttendees, cateringType, "Catering");
      specificBooking.servicesList.add(catering);
      MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage("Catering "+"("+cateringType.getName()+")", bookingReference);
    }
    else{
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Catering", bookingReference);
    }
    
  }

  public void addServiceMusic(String bookingReference) {
    if (doesRefExist(allBookings, bookingReference)){
      Booking specificBooking=getSpecificBooking(bookingReference, allBookings);
      MusicService music= new MusicService("Music");
      specificBooking.servicesList.add(music);
      MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage("Music", bookingReference);
    }
    else {
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Music", bookingReference);
    }
   
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    if (doesRefExist(allBookings, bookingReference)){
      Booking specificBooking=getSpecificBooking(bookingReference, allBookings);
      FloralService floral = new FloralService(floralType, "Floral");
      specificBooking.servicesList.add(floral);
      MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage("Floral "+"("+floralType.getName()+")",bookingReference);
    }
    else{
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Floral", bookingReference);
    }
    

  }

  public void viewInvoice(String bookingReference) {
    int cost=0;
    if (doesRefExist(allBookings, bookingReference)){
      
      Booking specificBooking=getSpecificBooking(bookingReference, allBookings);
      Venue specificVenue=getSpecificVenue(specificBooking.venueCode, venueList);
      MessageCli.INVOICE_CONTENT_TOP_HALF.printMessage(bookingReference, specificBooking.email, specificBooking.dateOfBooking, specificBooking.requestedDate, specificBooking.attendees, specificVenue.venueName);
      cost=Integer.parseInt(specificVenue.hireFeeInput);
      //Cost Breakdown
      MessageCli.INVOICE_CONTENT_VENUE_FEE.printMessage(specificVenue.hireFeeInput);

      for (Service service: specificBooking.servicesList){

        if (service instanceof CateringService){
          cost += service.calculatingCost();
          CateringService catering= (CateringService) service;
          //Accessing catering service
          MessageCli.INVOICE_CONTENT_CATERING_ENTRY.printMessage(catering.getCateringType().getName(),Integer.toString(service.calculatingCost()));
        }
        else if (service instanceof MusicService){
          cost +=service.calculatingCost();
          MessageCli.INVOICE_CONTENT_MUSIC_ENTRY.printMessage(Integer.toString(service.calculatingCost()));
        }
        else if (service instanceof FloralService){
          cost +=service.calculatingCost();
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
