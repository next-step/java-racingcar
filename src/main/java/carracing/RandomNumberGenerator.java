package carracing;

import java.util.Random;

public class RandomNumberGenerator {
  private static final Random random = new Random();

  public static int generate() {
    return random.nextInt(10);
  }
}
