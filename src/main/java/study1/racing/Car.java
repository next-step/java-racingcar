package study1.racing;

import java.util.Random;

public class Car {
  private int distance = 1;

  public Car() {
  }

  public int move() {
    distance += new Random().nextInt(2);
    return distance;
  }
}
