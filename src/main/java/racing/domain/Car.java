package racing.domain;

import java.util.Objects;

/**
 * 자동차 이동 로직
 */
public class Car implements Comparable<Car> {

  private static final int MOVE_BORDER = 4;
  private final CarName name;
  private final Position position;

  public Car(String name) {
    this(new CarName(name));
  }

  public Car(String name, int position) {
    this(new CarName(name), new Position(position));
  }

  public Car(CarName name) {
    this(name, new Position(0));
  }

  public Car(CarName name, Position position) {
    this.name = name;
    this.position = position;
  }

  public void move(int value) {
    if (value > MOVE_BORDER) {
      this.position.increase();
    }
  }

  public boolean hasSamePosition(Car car) {
    return this.position.equals(car.position);
  }

  public String getName() {
    return this.name.getName();
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return Objects.equals(name, car.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public int compareTo(Car o) {
    return this.position.compareTo(o.position);
  }

  @Override
  public String toString() {
    return this.name + " : " + this.position;
  }

}
