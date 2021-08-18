package step45.utils;

import java.util.Random;

public class RandomValueGenerator {

  private static final int MAX = 9;
  private static final Random random = new Random();

  private RandomValueGenerator() {
  }

  public static int getRandomNumber() {
    return random.nextInt(MAX);
  }
}
