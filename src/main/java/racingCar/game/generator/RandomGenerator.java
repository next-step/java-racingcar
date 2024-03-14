package racingCar.game.generator;

import java.util.Random;

public class RandomGenerator implements IntGenerator {

  private static final Random random = new Random();
  private final int upperBound;

  public RandomGenerator(int upperBound){
    this.upperBound = upperBound;
  }

  @Override
  public int nextInt() {
    return random.nextInt(upperBound);
  }
}
