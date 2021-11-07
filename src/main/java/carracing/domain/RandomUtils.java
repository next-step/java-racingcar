package carracing.domain;

import java.util.Random;

public class RandomUtils {


  private static Random random = new Random();

  private static final int TEN = 10;

  private RandomUtils() {}

  public static boolean greaterThanOrEquals(int number) {
    return random.nextInt(TEN) >= number;
  }



}
