package racingCar.game.generator;

import java.util.Random;

public class RandomGenerator implements IntGenerator {

  private static final Random random = new Random();

  @Override
  public int nextInt(int bound) {
    return random.nextInt(bound);
  }
}
