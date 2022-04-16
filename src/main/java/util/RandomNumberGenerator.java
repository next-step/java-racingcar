package util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {

  private RandomNumberGenerator() {}

  private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

  public static int generateRandomNumberInRange(int maxNumber) {
    return RANDOM.nextInt(maxNumber);
  }
}
