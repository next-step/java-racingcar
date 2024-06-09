package core.car;

public class Car {

  private String name;
  private Integer distance;

  public Car(String name, Integer startPosition) {
    this.name = name;
    this.distance = startPosition;
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
}
