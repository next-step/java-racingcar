package racing;

public class Car {

  private int location;

  public int getLocation() {
    return location;
  }

  public void move() {
    this.location += 1;
  }
}
