package nz.ac.auckland.se281;

public abstract class Service{
  int cost;
  String service;

  public Service(String service){
    this.service=service;
  }

  abstract public int calculatingCost();

  
}