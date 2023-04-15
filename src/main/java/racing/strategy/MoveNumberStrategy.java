package racing.strategy;

import java.util.Random;

public class MoveNumberStrategy implements NumberGeneratorStrategy {

  private static final Random RANDOM = new Random();

  private static final int NUMBER_FOR_MOVE = MAX_FOR_MOVE - MIN_FOR_MOVE + 1;

  public int getNumber() {
    return RANDOM.nextInt(NUMBER_FOR_MOVE) + MIN_FOR_MOVE;
  }
}
