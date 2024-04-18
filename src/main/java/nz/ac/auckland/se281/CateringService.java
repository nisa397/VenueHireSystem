package nz.ac.auckland.se281;
import nz.ac.auckland.se281.Types.CateringType;


public class CateringService extends Service{
  private int noOfAttendees;
  private CateringType cateringType;
  int cost;

  public CateringService(int noOfAttendees, CateringType cateringType){
    this.noOfAttendees=noOfAttendees;
    this.cateringType=cateringType;
    this.cost=calculatingCost();
  }


  @Override
  public int calculatingCost(){
    int cateringTypeCost= noOfAttendees*(cateringType.getCostPerPerson());
    return cateringTypeCost;
  }
}