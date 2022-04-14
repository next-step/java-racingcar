package racingCar.model;

import racingCar.strategy.CarMoveStrategy;

public class Car {

  private String name;
  private int position;

  public Car(String name) {
    this(name, 0);
  }

  public Car(String name, int position) {
    this.name = name;
    this.position = position;
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
