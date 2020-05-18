package racingcar;

import java.util.Random;

public class RandomUtil {

  static final int RANDOM_NUM_BOUND = 10;
  Random random = new Random();

  public Integer getRandomValue() {
    return random.nextInt(RANDOM_NUM_BOUND);
  }
}
