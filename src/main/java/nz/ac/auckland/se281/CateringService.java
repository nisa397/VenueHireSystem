package nz.ac.auckland.se281;
import nz.ac.auckland.se281.Types.CateringType;


public class CateringService extends Service{
  private int noOfAttendees;
  private CateringType cateringType;
  int cost;

  public CateringService(int noOfAttendees, CateringType cateringType, String serviceType){
    super(serviceType);
    this.noOfAttendees=noOfAttendees;
    this.cateringType=cateringType;
    this.cost=calculatingCost();
  }

  public CateringType getCateringType() {
    return cateringType;
  }

  @Override
  public int calculatingCost(){
    int cateringTypeCost= noOfAttendees*(cateringType.getCostPerPerson());
    return cateringTypeCost;
  }
}