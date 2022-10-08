package racingcar.domain.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

  private static final int MIN_NUMBER = 4;
  private static final int MAX_NUMBER = 10;

  @Override
  public boolean isMoveAble() {
    Random random = new Random();
    int randomNum = random.nextInt(MAX_NUMBER);
    return MIN_NUMBER <= randomNum;
  }
}
