package racing;

public class Car {

  private int location;

  public int nowLocation() {
    return location;
  }

  public void move(int distance) {
    this.location += distance;
  }
}
