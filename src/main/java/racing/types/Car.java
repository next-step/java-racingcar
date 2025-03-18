package racing.types;

import racing.simulator.RacingCarMovingStrategy;

public class Car {

  private final CarName carName;
  private int location;

  public Car() {
    this(new CarName());
  }

  public Car(CarName carName) {
    this.carName = carName;
    this.location = 0;
  }

  public Car(Car car) {
    this.location = car.location;
    this.carName = car.carName;
  }

  public int getLocation() {
    return location;
  }

  public String getName() {
    return carName.getName();
  }

  public void go(RacingCarMovingStrategy racingCarMovingStrategy) {
    if (racingCarMovingStrategy.canMove()) {
      this.location += 1;
    }
  }

  public void reset() {
    location = 0;
  }
}
