package study.racinggame.domain;

import java.util.Random;

public class RacingStrategy {
  private static final int RANDOM_RANGE = 10;
  private static final int MOVABLE_CRITERIA = 4;
  private static final Random random = new Random();

  private int randomNumber() {
    return random.nextInt(RANDOM_RANGE);
  }

  public boolean movable() {
    return randomNumber()  >= MOVABLE_CRITERIA;
  }
}
