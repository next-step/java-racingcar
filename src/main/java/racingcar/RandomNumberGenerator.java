package racingcar;

import java.util.Random;

public class RandomNumberGenerator {

  final static Random RANDOM = new Random();

  public static int randomValue() {
    return RANDOM.nextInt(10);
  }
}
