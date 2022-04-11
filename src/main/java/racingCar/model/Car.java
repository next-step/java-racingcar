package racingCar.model;

import racingCar.strategy.CarMoveStrategy;

public class Car {

  private final String name;
  private int position;
  private static final Integer MAX_NAME_LENGTH = 5;

  public Car(String name) {
    validationNameSize(name);
    this.name = name;
  }

  private void validationNameSize(String name) {
    if (MAX_NAME_LENGTH < name.length()) {
      throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
    }
  }

  public int move(CarMoveStrategy carMoveStrategy) {
    if (carMoveStrategy.moveAble()) {
      return position += 1;
    }
    return position;
  }

  public int position() {
    return this.position;
  }
}
