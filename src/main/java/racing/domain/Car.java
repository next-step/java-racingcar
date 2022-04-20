package racing.domain;

import racing.domain.strategy.MoveStrategy;

public class Car {

  private final Distance distance;
  private final CarName carName;

  public Car(String carName) {
    this.distance = new Distance();
    this.carName = new CarName(carName);
  }

  public static Car newInstance(String carName) {
    return new Car(carName);
  }

  public String getCarName() {
    return carName.getValue();
  }

  public void attempt(MoveStrategy moveStrategy) {
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
