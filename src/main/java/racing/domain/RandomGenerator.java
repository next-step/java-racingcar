package racing.domain;

import java.util.Random;

public class RandomGenerator implements NumberGenerator {
  private static final Random random = new Random();

  @Override
  public int generate() {
    return random.nextInt(10);
  }
}
