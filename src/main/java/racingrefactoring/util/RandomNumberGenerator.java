package racingrefactoring.util;

import java.util.Random;

public class RandomNumberGenerator {

  private static final int BOUND = 10;
  private static final Random random = new Random();
  public static int generateNumber() {
    return random.nextInt(BOUND);
  }
}
