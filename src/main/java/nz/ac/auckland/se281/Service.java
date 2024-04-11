package nz.ac.auckland.se281;
import java.util.ArrayList;

public abstract class Service{
  String inpBookingRef;
  int cost;


  public Service(String inpBookingRef){
    this.inpBookingRef=inpBookingRef;
  }


  abstract public int calculatingCost();

  public boolean doesRefExist(ArrayList <Booking> allBookings, String inpBookingRef){

    for (Booking booking: allBookings){

      if (booking.bookingRef.equals(inpBookingRef)){
        return true;

      }
    }

    return false;
  }
}