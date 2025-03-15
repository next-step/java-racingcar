package racing.simulator;

class Car {
  private int location;

  Car() {
    this.location = 0;
  }

  void go() {
    this.location += 1;
  }

  String getLocationConsoleFormat() {
    return "-".repeat(Math.max(0, location));
  }

  void reset() {
    location = 0;
  }
}
