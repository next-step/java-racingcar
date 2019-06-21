package racingcar.util;

import java.util.Random;

public class RandomNumberGenerator {

  final static Random RANDOM = new Random();
  final static int BOUND_NUMBER = 10;

  public static int randomValue() {
    return RANDOM.nextInt(BOUND_NUMBER);
  }
}
