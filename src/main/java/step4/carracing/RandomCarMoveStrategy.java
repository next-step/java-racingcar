package step4.carracing;

import java.util.Random;

public class RandomCarMoveStrategy implements CarMoveStrategy {
  private static final Random random = new Random();
  private static final int MAX_RANDOM_NUMBER = 10;
  static final int MOVE_THRESHOLD = 4;

  @Override
  public boolean shouldMove() {
    return getMoveSteps() >= MOVE_THRESHOLD;
  }

  int getMoveSteps() {
    return random.nextInt(MAX_RANDOM_NUMBER);
  }
}
