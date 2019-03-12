package racing;

import java.util.Random;

public class RandomGenerator {

  private int range;

  public RandomGenerator(int range) {
    this.range = range;
  }

  public boolean isMoving(int minNumber) {
    return new Random().nextInt(range) >= minNumber;
  }
}
