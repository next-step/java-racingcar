package racing.domain.strategy;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

  private static final int RANDOM_NEXT_INT_BOUND = 10;
  private final Random random;

  public RandomNumberGenerator() {
    this.random = new Random();
  }

  @Override
  public int generate() {
    return random.nextInt(RANDOM_NEXT_INT_BOUND);
  }
}
