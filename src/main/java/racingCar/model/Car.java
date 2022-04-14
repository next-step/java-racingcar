package racingCar.model;

import racingCar.strategy.CarMoveStrategy;

public class Car {

  private String name;
  private int position;
  private static final int MIN_CAR_NAME_LENGTH = 5;

  public Car(String name) {
    this(name, 0);
  }

  public Car(String name, int position) {
    carNameValidation(name);
    this.name = name;
    this.position = position;
  }

  public int move(CarMoveStrategy carMoveStrategy) {
    if (carMoveStrategy.moveAble()) {
      return position += 1;
    }
    return position;
  }

  private void carNameValidation(String name) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("자동차의 이름은 null이거나 공백일 수 없습니다.");
    }
    if (name.length() > MIN_CAR_NAME_LENGTH) {
      throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
    }
  }

  public int position() {
    return this.position;
  }
}
