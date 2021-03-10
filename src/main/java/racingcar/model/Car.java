package racingcar.model;

public class Car {

  private int location;

  public Car() {
    location = 0;
  }

  public void move() {
    location++;
  }

  public int getLocation() {
    return location;
  }

}
