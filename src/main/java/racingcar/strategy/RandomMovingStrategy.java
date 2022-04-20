package racingcar.strategy;

import racingcar.util.RandomRange;

public class RandomMovingStrategy implements MovingStrategy {

  private static final int RANDOM_MINIMUM_VALUE_CAN_BE_MOVED = 4;

  @Override
  public boolean decideWhetherToMove() {
    return RandomRange.getRandomValue() >= RANDOM_MINIMUM_VALUE_CAN_BE_MOVED;
  }
}
