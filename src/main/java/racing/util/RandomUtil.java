package racing.util;

import java.util.Random;

public class RandomUtil {

  private static final Random RANDOM = new Random();

  public static int getRandomValue() {
    return RANDOM.nextInt(10);
  }

}
