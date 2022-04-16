package racing.domain;

import racing.domain.strategy.MoveStrategy;

public class Car {

  private int distance;
  private final CarName carName;
  private final MoveStrategy moveStrategy;

  public Car(String carName, MoveStrategy moveStrategy) {
    this.carName = new CarName(carName);
    this.moveStrategy = moveStrategy;
  }

  public String getCarName() {
    return carName.getValue();
  }

  public static Car newInstance(String carName, MoveStrategy moveStrategy) {
    return new Car(carName, moveStrategy);
  }

  public void attempt() {
    if (moveStrategy.canMove()) {
      move();
    }
  }

  public void move() {
    this.distance++;
  }

  public int getDistance() {
    return distance;
  }

}
