package racing.simulator;

public class Car {
  private int location;

  Car() {
    this.location = 0;
  }

  Car(Car car) {
    this.location = car.location;
  }

  void go() {
    this.location += 1;
  }

  public String getLocationConsoleFormat() {
    return "-".repeat(Math.max(0, location));
  }

  void reset() {
    location = 0;
  }
}
