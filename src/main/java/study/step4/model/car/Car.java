package study.step4.model.car;

import study.step4.model.strategy.MoveStrategy;

public class Car {

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

  public void setDistance(int distance) {
    this.distance = distance;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  private void moveCar() {
    distance++;
  }

  public void move(MoveStrategy moveStrategy) {
    if (moveStrategy.isMoveCondition()) {
      moveCar();
    }
  }


}
