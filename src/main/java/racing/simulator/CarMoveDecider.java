package racing.simulator;

import java.util.Random;

class CarMoveDecider {

  private final Random random;

  public CarMoveDecider(Random random) {
    this.random = random;
  }

  boolean canMove() {
    return true;
  }
}
