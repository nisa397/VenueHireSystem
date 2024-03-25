package nz.ac.auckland.se281;

//import java.util.ArrayList;

public class Venue{
  String venueName;
  String venueCode;
  String capacityInput;
  String hireFeeInput;

 // ArrayList <String> venuCodeList;


 //Initialising constructor
  public Venue(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.capacityInput = capacityInput;
    this.hireFeeInput = hireFeeInput;
    //this.venueCodeList = new ArrayList<String>(); // Initialize venueCodeList
}

//Verifying instance fields

//Checking if venuename is blank
public boolean NameCheck(){
  System.out.println(this.venueName);

  
  //
  if (this.venueName.isBlank()==true){
    MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
    return false;
  }
  else {
    return true;
  }
    
  }


}




