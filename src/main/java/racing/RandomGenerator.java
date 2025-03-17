package racing;

import java.util.Random;

public class RandomGenerator {
  private static final Random random = new Random();

  public static int generate() {
    return random.nextInt(10);
  }
}
