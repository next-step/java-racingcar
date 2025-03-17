package step4.carracing;

import java.util.Random;

public class RandomCarMoveStrategy implements CarMoveStrategy {
  private static final Random random = new Random();
  private static final int MAX_RANDOM_NUMBER = 10;

  @Override
  public int getMoveSteps() {
    return random.nextInt(MAX_RANDOM_NUMBER);
  }
}
