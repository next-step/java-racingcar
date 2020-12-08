package step3.service;

import java.util.Random;

public class RandomRacingRule implements RacingRule {

  private static final Random random = new Random();
  private static final int STANDARD_FOR_MOVING = 4;
  private static final int RANDOM_BOUND = 10;

  @Override
  public boolean canMove(int targetNumber) {
    return targetNumber > STANDARD_FOR_MOVING;
  }

  @Override
  public int getTargetNumber() {
    return random.nextInt(RANDOM_BOUND);
  }

}
