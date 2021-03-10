package study1.racing;

public class Car {
  private int distance = 1;

  public Car() {
  }

  public int move() {
    distance += (int) (Math.random() * 2);
    return distance;
  }
}
