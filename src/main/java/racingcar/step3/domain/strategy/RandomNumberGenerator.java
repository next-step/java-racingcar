package racingcar.step3.domain.strategy;

import java.util.Random;

public class RandomNumberGenerator implements MoveNumberGenerator {

  private static final Random random = new Random();

  public RandomNumberGenerator() {}

  public int generate(int bound) {
    return random.nextInt(bound);
  }
}
