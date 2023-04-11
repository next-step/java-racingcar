package study.racinggame.domain;

import java.util.Random;

public class RacingGameStrategy implements GameStrategy {
  private static final int RANDOM_RANGE = 10;
  private static final int MOVABLE_CRITERIA = 4;
  private static final Random random = new Random();

  @Override
  public boolean movable() {
    return randomNumber() >= MOVABLE_CRITERIA;
  }

  private int randomNumber() {
    return random.nextInt(RANDOM_RANGE);
  }
}
