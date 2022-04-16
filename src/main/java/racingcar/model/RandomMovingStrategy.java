package racingcar.model;

import racingcar.util.RandomUtil;

public class RandomMovingStrategy implements MovingStrategy {

  private static final int MOVE_BOUND = 4;
  private static final RandomMovingStrategy STRATEGY = new RandomMovingStrategy();

  private RandomMovingStrategy() {
  }

  public static RandomMovingStrategy getInstance() {
    return STRATEGY;
  }

  @Override
  public boolean movable() {
    return RandomUtil.createRandomNumber() >= MOVE_BOUND;
  }
}
