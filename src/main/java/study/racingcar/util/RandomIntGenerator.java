package study.racingcar.util;

import java.util.Random;

public class RandomIntGenerator {

  private static final Random RANDOM_INSTANCE = new Random();

  public static int generateMaxBound(int bound) {
    return RANDOM_INSTANCE.nextInt(bound);
  }
}
