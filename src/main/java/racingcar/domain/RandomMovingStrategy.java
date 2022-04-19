package racingcar.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

  private static final int MAX_BOUND = 10;
  private static final int MOVE_BOUND = 4;
  private static final Random RANDOM = new Random();
  private static final RandomMovingStrategy STRATEGY = new RandomMovingStrategy();

  private RandomMovingStrategy() {
  }

  public static RandomMovingStrategy getInstance() {
    return STRATEGY;
  }

  @Override
  public boolean movable() {
    return createRandomNumber() >= MOVE_BOUND;
  }

  private int createRandomNumber() {
    return RANDOM.nextInt(MAX_BOUND);
  }
}
