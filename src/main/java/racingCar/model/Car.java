package racingCar.model;

import java.util.Objects;
import racingCar.strategy.CarMoveStrategy;

public class Car {

  private static final int MIN_CAR_NAME_LENGTH = 5;
  private String name;
  private int position;

  public Car(String name) {
    this(name, 0);
  }

  public Car(String name, int position) {
    carNameValidation(name);
    this.name = name;
    this.position = position;
  }

  public Car move(CarMoveStrategy carMoveStrategy) {
    if (carMoveStrategy.moveAble()) {
      return new Car(this.name, this.position + 1);
    }
    return this;
  }

  private void carNameValidation(String name) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("자동차의 이름은 null이거나 공백일 수 없습니다.");
    }
    if (name.length() > MIN_CAR_NAME_LENGTH) {
      throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return position == car.position && Objects.equals(name, car.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, position);
  }

  public int position() {
    return this.position;
  }

  @Override
  public String toString() {
    return "Car{" +
        "name='" + name + '\'' +
        ", position=" + position +
        '}';
  }
}
