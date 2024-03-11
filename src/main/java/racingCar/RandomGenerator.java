package racingCar;

import java.util.Random;

public class RandomGenerator implements IntGenerator {

  private final Random random;

  public RandomGenerator() {
    this.random = new Random();
  }

  @Override
  public int nextInt(int bound) {
    return random.nextInt(bound);
  }
}
