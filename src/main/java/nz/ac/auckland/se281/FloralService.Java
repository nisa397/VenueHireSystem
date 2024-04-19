package nz.ac.auckland.se281;
import nz.ac.auckland.se281.Types.FloralType;

public class FloralService extends Service{
  int cost;
  private FloralType floralType;



  public FloralService(FloralType floralType, String serviceType){
    super(serviceType);
    this.floralType=floralType;
    this.cost=calculatingCost();
  }

  public FloralType getFloralType() {
    return floralType;
  }

  public int calculatingCost(){
    int floralTypeCost=floralType.getCost();
    return floralTypeCost;
  }
}