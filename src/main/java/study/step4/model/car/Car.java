package study.step4.model.car;

import study.step4.model.strategy.MoveStrategy;

public class Car implements Comparable<Car>{

  private static final int CAR_NAME_MAX_LENGTH = 5;

  private int distance;
  private String name;

  public Car() {
  }

  public Car(String carName) {
    if (carName.length() > CAR_NAME_MAX_LENGTH) {
      throw new IllegalArgumentException();
    }

    this.name = carName;
    this.distance = 0;
  }

  public int getDistance() {
    return distance;
  }

  public String getName() {
    return name;
  }

  public void move(MoveStrategy moveStrategy) {
    if (moveStrategy.isMoveCondition()) {
      distance++;
    }
  }

  @Override
  public int compareTo(Car other) {
    return Integer.compare(this.distance, other.distance);
  }
}
