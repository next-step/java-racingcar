package util;

import java.util.Random;

public class RandomNumberGenerator {

  public static final int UNITS_DIGIT_BOUND = 10;

  public static int generateUnitsDigit() {
    Random random = new Random();
    return random.nextInt(UNITS_DIGIT_BOUND);
  }
}
