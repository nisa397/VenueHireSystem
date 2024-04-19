package nz.ac.auckland.se281;

public class MusicService extends Service{
  int cost;
  public MusicService(String service){
    super(service);
  }


  public int calculatingCost(){
    return this.cost=500;
  };
}

