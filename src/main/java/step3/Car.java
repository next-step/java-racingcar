package step3;

public class Car {

  private int location;

  public Car() {
    location = 0;
  }

  public void move() {
    this.location++;
  }

  public int getLocation() {
    return location;
  }
}
