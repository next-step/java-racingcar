package racing.domain;

import java.util.Objects;
import racing.domain.strategy.MoveStrategy;

public class Car {

  private final Distance distance;
  private final CarName carName;

  public Car(String carName) {
    this(carName, new Distance(0));
  }

  public Car(String carName, Distance distance) {
    this.distance = distance;
    this.carName = new CarName(carName);
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Car)) {
      return false;
    }
    Car car = (Car) o;
    return Objects.equals(distance, car.distance) && Objects.equals(carName,
        car.carName);
  }

}
