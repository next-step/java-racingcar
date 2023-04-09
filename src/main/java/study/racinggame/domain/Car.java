package study.racinggame.domain;

public class Car {

  private int distance;

  public Car() {
    this.distance = 0;
  }

  public int distance() {
    return distance;
  }

  public void forward(boolean movable) {
    if (movable) {
      distance++;
    }
  }
}
