package util;

import java.util.Random;

public final class RandomUtils {

  private RandomUtils() {}
  private static final Random random = new Random();

  public static int getRandomSinglePositiveDigit() {
    return random.nextInt(10);
  }
}
