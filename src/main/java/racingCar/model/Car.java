package racingCar.model;

import racingCar.strategy.CarMoveStrategy;

public class Car {

  private int meterParser;

  public int step(CarMoveStrategy carMoveStrategy) {
    if (carMoveStrategy.moveAble()) {
      return meterParser += 1;
    }
    return meterParser;
  }

  public int position() {
    return this.meterParser;
  }
}
