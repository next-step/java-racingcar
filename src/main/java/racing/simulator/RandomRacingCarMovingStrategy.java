package racing.simulator;

import java.util.Random;

public class RandomRacingCarMovingStrategy implements RacingCarMovingStrategy {

  private final Random random;
  private static final int MOVE_THRESHOLD = 4;
  private static final int RANDOM_RANGE_LIMIT = 10;

  public RandomRacingCarMovingStrategy() {
    this.random = new Random();
  }

  public RandomRacingCarMovingStrategy(Random random) {
    this.random = random;
  }

  public boolean canMove() {
    return random.nextInt(RANDOM_RANGE_LIMIT) >= MOVE_THRESHOLD;
  }
}
