package study.racingcar.util;

import java.util.Random;

public class RandomInt {

  private static final Random RANDOM_INSTANCE = new Random();

  public static int makeRandomInt(int bound) {
    return RANDOM_INSTANCE.nextInt(bound);
  }
}
