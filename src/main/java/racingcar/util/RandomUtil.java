package racingcar.util;

import java.util.Random;

public class RandomUtil {

  private Random random;

  public RandomUtil() {
    this.random = new Random();
  }

  public int nextInt() {
    return this.random.nextInt(10);
  }

}
