package nz.ac.auckland.se281;

import java.util.ArrayList;

//import java.util.ArrayList;

public class Venue{
  String venueName;
  String venueCode;
  String capacityInput;
  String hireFeeInput;
  ArrayList <String> Venues;

 // ArrayList <String> venuCodeList;


 //Initialising constructor
  public Venue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.capacityInput = capacityInput;
    this.hireFeeInput = hireFeeInput;
    Venues=new ArrayList<String>();
  }

//Verifying inputs for the instance fields

//Checking if venue name is valid



//Checking if the venue code is valid
public boolean CodeCheck(){
  for (String iterator: Venues){
    if (this.venueCode==iterator){
      MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage();
      return false;
    }
  }
  return true;
}  




}




