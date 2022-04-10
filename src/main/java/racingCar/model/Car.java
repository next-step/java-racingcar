package racingCar.model;

import racingCar.strategy.CarMoveStrategy;

public class Car {


  private final static String STEP = "-";
  private int meterParser;

  public int step(CarMoveStrategy carMoveStrategy) {
    if (carMoveStrategy.moveAble()) {
      return meterParser += 1;
    }
    return meterParser;
  }


  public String move() {
    return STEP.repeat(Math.max(0, getMeterParser()));
  }

  public int getMeterParser() {
    return meterParser;
  }


}
