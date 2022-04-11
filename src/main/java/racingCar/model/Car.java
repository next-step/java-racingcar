package racingCar.model;

import racingCar.strategy.CarMoveStrategy;

public class Car {

  private int position;
  private String name;
  public Car(String name) {
    this.name = name;
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
