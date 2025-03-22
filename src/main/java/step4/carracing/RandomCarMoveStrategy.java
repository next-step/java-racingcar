package step4.carracing;

import java.util.Random;

public class RandomCarMoveStrategy implements CarMoveStrategy {
  private static final Random random = new Random();
  private static final int MAX_RANDOM_NUMBER = 10;
  private static final int MOVE_THRESHOLD = 4;

  @Override
  public boolean shouldMove() {
    return getRandomStep() >= MOVE_THRESHOLD;
  }

  private int getRandomStep() {
    return random.nextInt(MAX_RANDOM_NUMBER);
  }
}
