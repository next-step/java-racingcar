package racingcar;

import java.util.Objects;

public class Car {
  private final Location location;
  private final CarName name;

  public Car() {
    this("", 0);
  }

  public Car(String name, int location) {
    this.name = new CarName(name);
    this.location = new Location(location);
  }

  public Car(final int location) {
    this("", location);
  }

  public Car(final String name) {
    this(name, 0);
  }

  public void moveConditionally(final Condition condition) {
    this.location.forwardConditionally(meetMoveCondition(condition));
  }

  private boolean meetMoveCondition(final Condition condition) {
    final int NUMBER_CRITERION = 4;
    final Criteria criteria = new Criteria(NUMBER_CRITERION);
    return criteria.accepts(condition);
  }

  public boolean isLocatedAt(final int location) {
    return this.location.equals(location);
  }

  public String trace(final String distanceUnit) {
    return this.location.multiply(distanceUnit);
  }

  public String name() {
    return this.name.toString();
  }

  public boolean furtherThan(final Car car) {
    return this.location.furtherThan(car.location);
  }

  public boolean closerThan(final Car car) {
    return this.location.closerThan(car.location);
  }

  public boolean atTheSameLocationWith(final Car car) {
    return this.location.equals(car.location);
  }
  @Override
  public String toString() {
    return String.format("name: %s, location: %s", this.name, this.location);
  }

  public Car furtherCar(final Car car) {
    if (!this.closerThan(car)) {
      return this;
    }

    return car;
  }

  @Override
  public boolean equals(Object target) {
    if (target instanceof Car) {
      return ((Car) target).name.equals(this.name)
              && ((Car) target).location.equals(this.location);
    }

    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.location);
  }
}
