package racingCar.model;

import java.util.Objects;
import racingCar.strategy.CarMoveStrategy;

public class Car {

  private static final int MIN_CAR_NAME_LENGTH = 5;
  private final Integer index;
  private final String name;
  private final Position position;

  public Car(Integer index, String name) {
    this(index, name, 0);
  }

  public Car(Integer index, String name, int position) {
    carNameValidation(name);
    this.index = index;
    this.name = name;
    this.position = new Position(position);
  }

  public Car move(CarMoveStrategy carMoveStrategy) {
    if (carMoveStrategy.moveAble()) {
      return new Car(this.index, this.name, this.position.increase());
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
    return position.x == car.position.x && Objects.equals(index, car.index)
        && Objects.equals(name, car.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(index, name, position.x);
  }

  public Position position() {
    return this.position;
  }

  public Integer index() {
    return index;
  }


  @Override
  public String toString() {
    return name;
  }
}
