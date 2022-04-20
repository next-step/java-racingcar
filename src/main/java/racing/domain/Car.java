package racing.domain;

import racing.domain.strategy.MoveStrategy;

public class Car {

  private Distance distance;
  private final CarName carName;
  private final MoveStrategy moveStrategy;

  public Car(String carName, MoveStrategy moveStrategy) {
    this.distance = new Distance();
    this.carName = new CarName(carName);
    this.moveStrategy = moveStrategy;
  }

  public static Car newInstance(String carName, MoveStrategy moveStrategy) {
    return new Car(carName, moveStrategy);
  }

  public String getCarName() {
    return carName.getValue();
  }

  public void attempt() {
    if (moveStrategy.canMove()) {
      move();
    }
  }

  public boolean isDistanceEqual(Distance distance) {
    return this.distance.equals(distance);
  }

  public void move() {
    this.distance.increase();
  }

  public Distance getMaxDistance(Distance maxDistance) {
    return this.distance.getLarger(maxDistance);
  }

  public int getCurrentDistance() {
    return this.distance.getAmount();
  }
}
