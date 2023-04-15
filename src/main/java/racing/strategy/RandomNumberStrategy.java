package racing.strategy;

import java.util.Random;

public class RandomNumberStrategy implements NumberGeneratorStrategy {

  private static final Random RANDOM = new Random();

  public int getNumber() {
    return RANDOM.nextInt(MAX_FOR_MOVE + 1);
  }
}
