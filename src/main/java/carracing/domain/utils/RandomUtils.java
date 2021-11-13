package carracing.domain.utils;

import java.util.Random;

public class RandomUtils {

  private final static Random random = new Random();

  private static final int TEN = 10;

  private RandomUtils() {}

  public static boolean isGreaterThanOrEquals(int number) {
    return random.nextInt(TEN) >= number;
  }

}
