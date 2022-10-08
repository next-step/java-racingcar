package racingCar.strategy;

import racingcar.domain.strategy.MovingStrategy;

public class TestMovingStrategy implements MovingStrategy {


  @Override
  public boolean isMoveAble() {
    return true;
  }
}
