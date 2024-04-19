package nz.ac.auckland.se281;
import nz.ac.auckland.se281.Types.FloralType;


public class FloralService extends Service{
  int cost;
  private FloralType floralType;

  //Constructor, calculates cost everytime the floralservice constructor is called
  public FloralService(FloralType floralType, String serviceType){
    super(serviceType);
    this.floralType=floralType;
    this.cost=calculatingCost();
  }

  public FloralType getFloralType() {
    return floralType;
  }

  //Calculates cost by retrieving the inputted floral type
  public int calculatingCost(){
    int floralTypeCost=floralType.getCost();
    return floralTypeCost;
  }
}