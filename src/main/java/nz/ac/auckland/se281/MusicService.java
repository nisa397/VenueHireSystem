package nz.ac.auckland.se281;

public class MusicService extends Service {
  private int cost;

  public MusicService(String serviceType) {
    super(serviceType);
  }

  @Override
  public int calculatingCost() {
    // cost is $500 for music service
    return this.cost = 500;
  }
  ;

  public int getCost() {
    return this.cost;
  }
}
