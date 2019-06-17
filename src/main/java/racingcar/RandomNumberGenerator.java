package racingcar;

import java.util.Random;

public class RandomNumberGenerator {

  public static int randomValue() {
    Random random = new Random();
    return random.nextInt(10);
  }
}
