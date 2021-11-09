package racingcar.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

  private final int MOVING_REFERENCE_VALUE = 4;
  private final int BOUND_LIMIT = 10;
  @Override
  public boolean isMovable() {
    if (MOVING_REFERENCE_VALUE <= getRandomNumber()) {
      return true;
    }
    return false;
  }

  private int getRandomNumber() {
    return new Random().nextInt(BOUND_LIMIT);
  }
}
