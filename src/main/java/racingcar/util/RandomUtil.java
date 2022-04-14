package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtil {

  private static final int MAX_BOUND = 10;
  private static final Random RANDOM_SINGLETON = new Random();

  private RandomUtil() {
  }

  public static int getRandomNumber() {
    return RANDOM_SINGLETON.nextInt(MAX_BOUND);
  }

  public static List<Integer> getRandomNumbers(int size) {
    List<Integer> randomNumbers = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      randomNumbers.add(RandomUtil.getRandomNumber());
    }
    return randomNumbers;
  }
}
