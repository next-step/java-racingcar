package racing.simulator;

import java.util.Random;

class CarMoveDecider {

  private final Random random;
  private static final int MOVE_THRESHOLD= 4;
  private static final int RANDOM_RANGE_LIMIT = 10;

  public CarMoveDecider(Random random) {
    this.random = random;
  }

  boolean canMove() {
    return random.nextInt(RANDOM_RANGE_LIMIT) >= MOVE_THRESHOLD;
  }
}
