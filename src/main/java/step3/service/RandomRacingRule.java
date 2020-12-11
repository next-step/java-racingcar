package step3.service;

import java.util.Random;

public class RandomRacingRule implements RacingRule {

  private static final Random random = new Random();
  private final int bound;

  public RandomRacingRule(int bound) {
    this.bound = bound;
  }

  @Override
  public int getTargetNumber() {
    return random.nextInt(bound);
  }

}
