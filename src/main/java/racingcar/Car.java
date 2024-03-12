package racingcar;

public class Car {
  private int location;
  private CarName name;

  public Car() {
    this("", 0);
  }

  public Car(String name, int location) {
    this.name = new CarName(name);
    this.location = location;
  }

  public Car(int location) {
    this("", location);
  }

  public Car(String name) {
    this(name, 0);
  }

  public void moveConditionally(final int condition) {
    if (meetMoveCondition(condition)) {
      this.location++;
    }
  }

  private boolean meetMoveCondition(final int condition) {
    final int CRITERIA = 4;
    return condition >= CRITERIA;
  }

  public boolean isLocationValueOf(final int location) {
    return this.location == location;
  }

  public String trace(final String distanceUnit) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < this.location; i++) {
      sb.append(distanceUnit);
    }

    return sb.toString();
  }

  public String name() {
    return this.name.toString();
  }

  public boolean furtherThan(final Car car) {
    return this.furtherThan(car.location);
  }

  private boolean furtherThan(final int location) {
    return this.location > location;
  }

  public boolean closerThan(final Car car) {
    return this.closerThan(car.location);
  }

  private boolean closerThan(int location) {
    return this.location < location;
  }

  public boolean atTheSameLocationWith(final Car car) {
    return this.location == car.location;
  }
  @Override
  public String toString() {
    return String.format("name: %s, location: %d", this.name, this.location);
  }

  public Car furtherCar(final Car car) {
    if (this.furtherThan(car)) {
      return this;
    }

    if (this.closerThan(car)) {
      return car;
    }

    return this;
  }
}
