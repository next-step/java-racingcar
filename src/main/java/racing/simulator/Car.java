package racing.simulator;

public class Car {

  private int location;
  private final CarMovingStrategy carMovingStrategy;

  public Car(CarMovingStrategy carMovingStrategy) {
    this.location = 0;
    this.carMovingStrategy = carMovingStrategy;
  }

  public Car(Car car) {
    this.location = car.location;
    this.carMovingStrategy = car.carMovingStrategy;
  }

  public int getLocation() {
    return location;
  }

  public void go() {
    if (carMovingStrategy.isMove()) {
      this.location += 1;
    }
  }

  public void reset() {
    location = 0;
  }
}
