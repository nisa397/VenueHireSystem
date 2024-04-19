package nz.ac.auckland.se281;

public abstract class Service {
  private int cost;
  private String serviceType;

  public Service(String serviceType) {
    this.serviceType = serviceType;
  }

  // Every service calculates cost differently
  public abstract int calculatingCost();

  public String getServiceType() {
    return serviceType;
  }
}
