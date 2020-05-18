package racingcar.util;

public class RandomUtil {

  static final int RANDOM_NUM_BOUND = 10;

  public static Integer getRandomValue() {
    return (int) (Math.random() * RANDOM_NUM_BOUND);
  }
}
