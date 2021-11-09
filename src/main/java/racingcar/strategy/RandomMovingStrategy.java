package racingcar.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
  @Override
  public boolean isMovable() {
    if (4 <= getRandomNumber()) {
      return true;
    }
    return false;
  }

  private int getRandomNumber() {
    return new Random().nextInt(10);
  }
}
