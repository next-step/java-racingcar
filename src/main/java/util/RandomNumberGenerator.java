package util;

import java.util.Random;

public class RandomNumberGenerator {

  private RandomNumberGenerator() {}

  private static final Random RANDOM = new Random();

  public static int generateRandomNumberInRange(int maxNumber) {
    RANDOM.setSeed(System.currentTimeMillis());
    return RANDOM.nextInt(maxNumber);
  }
}
