package racingcar.step3.util;

import java.util.Random;

public class RandomNumberUtil {

  private static final Random random = new Random();

  private RandomNumberUtil() {
    throw new AssertionError();
  }

  public static int generate(int bound) {
    return random.nextInt(bound);
  }
}
