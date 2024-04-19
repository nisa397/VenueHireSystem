package nz.ac.auckland.se281;

public abstract class Service{
  int cost;
  String serviceType;

  public Service(String serviceType){
    this.serviceType=serviceType;
  }

  abstract public int calculatingCost();

  
}