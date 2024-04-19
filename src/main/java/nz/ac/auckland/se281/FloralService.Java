package nz.ac.auckland.se281;
import nz.ac.auckland.se281.Types.FloralType;

public class FloralService extends Service{
  int cost;
  private FloralType floralType;



  public FloralService(FloralType floralType, String service){
    super(service);
    this.floralType=floralType;
    this.cost=calculatingCost();
  }

  public int calculatingCost(){
    int floralTypeCost=floralType.getCost();
    return floralTypeCost;
  }
}