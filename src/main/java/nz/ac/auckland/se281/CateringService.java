package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;

public class CateringService extends Service {
  private int noOfAttendees;
  private CateringType cateringType;
  private int cost;

  //
  public CateringService(int noOfAttendees, CateringType cateringType, String serviceType) {
    super(serviceType);
    this.noOfAttendees = noOfAttendees;
    this.cateringType = cateringType;
    this.cost = calculatingCost();
  }

  // Getter method to get inputted cateringtype
  public CateringType getCateringType() {
    return cateringType;
  }

  @Override
  public int calculatingCost() {
    // Cacluclates cost by multiplying number of attendees with correspodning cost for specific
    // catering type
    int cateringTypeCost = noOfAttendees * (cateringType.getCostPerPerson());
    return cateringTypeCost;
  }

  public int getCost() {
    return this.cost;
  }
}
