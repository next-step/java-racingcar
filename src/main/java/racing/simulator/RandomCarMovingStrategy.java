package racing.simulator;

import java.util.Random;

public class RandomCarMovingStrategy implements CarMovingStrategy {

  private final Random random;
  private static final int MOVE_THRESHOLD = 4;
  private static final int RANDOM_RANGE_LIMIT = 10;

  public RandomCarMovingStrategy() {
    this.random = new Random();
  }

  public RandomCarMovingStrategy(Random random) {
    this.random = random;
  }

  public boolean canMove() {
    return random.nextInt(RANDOM_RANGE_LIMIT) >= MOVE_THRESHOLD;
  }
}
