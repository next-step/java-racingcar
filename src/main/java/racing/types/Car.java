package racing.types;

import racing.simulator.CarMovingStrategy;

public class Car {

  private final CarName carName;
  private int location;

  public Car() {
    this(new CarName());
  }

  public static Car valueOf(Car car) {
    return new Car(car);
  }

  public static Car valueOf(CarName carName) {
    return new Car(carName);
  }

  private Car(CarName carName) {
    this.carName = carName;
    this.location = 0;
  }

  private Car(Car car) {
    this.location = car.location;
    this.carName = car.carName;
  }

  public int getLocation() {
    return location;
  }

  public String getName() {
    return carName.getName();
  }

  public void go(CarMovingStrategy carMovingStrategy) {
    if (carMovingStrategy.canMove()) {
      this.location += 1;
    }
  }

  public void reset() {
    location = 0;
  }
}
