package core.car;

public class Car {

  private String name;
  private Integer distance;
  private Integer goCost;

  public Car(String name, Integer distance) {
    this.name = name;
    this.distance = distance;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getDistance() {
    return distance;
  }

  public void setDistance(Integer distance) {
    this.distance = distance;
  }

  public Integer getGoCost() {
    return goCost;
  }

  public void setGoCost(Integer goCost) {
    this.goCost = goCost;
  }
}
