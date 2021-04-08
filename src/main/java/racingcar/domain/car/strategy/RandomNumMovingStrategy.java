package racingcar.domain.car.strategy;

import java.util.Random;

public class RandomNumMovingStrategy implements MovingStrategy {

  private static final Random random = new Random();

  @Override
  public boolean isCanMove() {
    return random.nextInt() >= 4;
  }
}
