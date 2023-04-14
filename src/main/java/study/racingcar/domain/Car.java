package study.racingcar.domain;

import study.racingcar.util.RandomInt;

public class Car {

  private static final int DEFAULT_BOUND = 10;
  private static final int MINIMUM_MOVE_VALUE = 4;
  private String name;
  private int distance;

  public Car(String name) {
    this.name = name;
  }

  public void move() {
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

  public String getName() {
    return name;
  }
}
