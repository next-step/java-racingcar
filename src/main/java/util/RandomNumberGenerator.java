package util;

import java.util.Random;

public class RandomNumberGenerator {

  public static final int UNITS_DIGIT_BOUND = 10;

  private static final Random random = new Random();

  public static int generateUnitsDigit() {
    return random.nextInt(UNITS_DIGIT_BOUND);
  }
}
