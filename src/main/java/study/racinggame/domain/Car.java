package study.racinggame.domain;

import static study.racinggame.util.NameValidator.validatedCarName;

public class Car implements Comparable<Car> {

  public static final Car ANONYMOUS_CAR = new Car("anony");
  private static final int DEFAULT_DISTANCE = 0;
  private final String name;
  private int distance;

  public Car(final String name) {
    this(name, DEFAULT_DISTANCE);
  }

  public Car(final String name, int distance) {
    this.name = validatedCarName(name);
    this.distance = distance;
  }

  public String name() {
    return name;
  }

  public int distance() {
    return distance;
  }

  public void forward(GameStrategy racingStrategy) {
    if (racingStrategy.movable()) {
      distance++;
    }
  }

  public boolean isSameDistance(Car car) {
    return equals(car);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Car car = (Car) o;

    return distance == car.distance;
  }

  @Override
  public int hashCode() {
    return distance;
  }

  @Override
  public int compareTo(Car otherCar) {
    return Integer.compare(distance, otherCar.distance());
  }
}
