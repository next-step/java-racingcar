package racingcar.model;

public class Car {

  private int location;
  private String name;

  public Car(String name) {
    this.name = name;
    this.location = 0;
  }

  public void move() {
    location++;
  }

  public int getLocation() {
    return location;
  }

  public String getName() {
    return name;
  }

}
