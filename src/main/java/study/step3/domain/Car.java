package study.step3.domain;

import study.step3.util.RandomInt;

public class Car {

  private static final int DEFAULT_BOUND = 10;
  private static final int MINIMUM_MOVE_VALUE = 4;
  private int distance;

  public void randomMove() {
    if (isMoving(getRandomInt())) {
      distance++;
    }
  }

  private int getRandomInt() {
    return RandomInt.makeRandomInt(DEFAULT_BOUND);
  }

  private boolean isMoving(int moveValue) {
    return moveValue >= MINIMUM_MOVE_VALUE;
  }

  public int getDistance() {
    return distance;
  }
}
