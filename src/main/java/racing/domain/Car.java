package racing.domain;

import java.util.Objects;

/**
 * 자동차 1. 전진 & 멈추기 2. 현재 위치 반환
 *
 */
public class Car implements Comparable<Car> {

  private static final int MOVE_BORDER = 4;
  private final CarName name;
  private Position position;

  public Car(String name) {
    this(new CarName(name));
  }

  public Car(CarName name) {
    this(name, new Position(0));
  }

  public Car(CarName name, Position position) {
    this.name = name;
    this.position = position;
  }

  public void move(int value) {
    if (value < MOVE_BORDER) {
      return;
    }
    this.position.move(1);
  }

  public Position getPosition() {
    return this.position;
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

  public String getName() {
    return this.name.getName();
  }

  @Override
  public int compareTo(Car o) {
    return this.position.compareTo(o.position);
  }

  public boolean hasSamePosition(Position position) {
    return this.position.equals(position);
  }
}
