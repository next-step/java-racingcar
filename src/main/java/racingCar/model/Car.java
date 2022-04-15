package racingCar.model;

import java.util.Objects;
import racingCar.strategy.CarMoveStrategy;

public class Car {

  private static final int MIN_CAR_NAME_LENGTH = 5;
  private Integer index;
  private String name;
  private int position;

  public Car(Integer index, String name) {
    this(index, name, 0);
  }

  public Car(Integer index, String name, int position) {
    carNameValidation(name);
    this.index = index;
    this.name = name;
    this.position = position;
  }

  public Car move(CarMoveStrategy carMoveStrategy) {
    if (carMoveStrategy.moveAble()) {
      return new Car(this.index, this.name, this.position + 1);
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
    return position == car.position && Objects.equals(index, car.index)
        && Objects.equals(name, car.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(index, name, position);
  }

  public int position() {
    return this.position;
  }

  public Integer index() {
    return index;
  }

  public String name() {
    return name;
  }

  @Override
  public String toString() {
    return "Car{" +
        "index=" + index +
        ", name='" + name + '\'' +
        ", position=" + position +
        '}';
  }
}
