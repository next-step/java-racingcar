package racingcar.util;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int RANDOM_NUMBER_BOUND = 10;
    private final Random seed;

    public RandomNumberGenerator(long currentTimeSeed) {
      this.seed = new Random(currentTimeSeed);
    }

    public int generateRandomNumber() {
      return seed.nextInt(RANDOM_NUMBER_BOUND);
    }
}
