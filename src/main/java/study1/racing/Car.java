package study1.racing;

import java.util.Random;

public class Car {
  private int distance = 0;

  public void setDistance(int movedDistance) {
    this.distance += movedDistance;
  }

  public Car() {
  }

  public int move() {
    setDistance(movedDistance(1));
    return distance;
  }

  // 이동한 거리 / min: 0, max: maxDistance
  public int movedDistance(int maxDistance) {
    return new Random().nextInt(maxDistance + 1);
  }
}
