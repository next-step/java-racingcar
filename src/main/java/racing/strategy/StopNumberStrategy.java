package racing.strategy;

import java.util.Random;

public class StopNumberStrategy implements NumberGeneratorStrategy {

  private static final Random RANDOM = new Random();

  public int getNumber() {
    return RANDOM.nextInt(MIN_FOR_MOVE);
  }
}
