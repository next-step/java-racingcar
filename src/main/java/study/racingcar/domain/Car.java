package study.racingcar.domain;

import study.racingcar.util.RandomIntGenerator;

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
    return RandomIntGenerator.generateMaxBound(DEFAULT_BOUND);
  }

  private boolean isMoving(int moveValue) {
    return moveValue >= MINIMUM_MOVE_VALUE;
  }

  public String getName() {
    return name;
  }
  
  public int getDistance() {
    return distance;
  }
}
