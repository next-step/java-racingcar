package racingCar.model;

import racingCar.strategy.CarMoveStrategy;

public class Car {

  private int position;

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
