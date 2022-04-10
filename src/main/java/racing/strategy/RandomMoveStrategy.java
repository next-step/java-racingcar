package racing.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

  private final Random random;
  private static final int MORE_THAN_NUMBER = 4;

  public RandomMoveStrategy() {
    this.random = new Random();
  }

  @Override
  public boolean isMove() {
    return random.nextInt(10) >= MORE_THAN_NUMBER;
  }
}
