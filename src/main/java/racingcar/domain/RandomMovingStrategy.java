package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class RandomMovingStrategy implements MovingStrategy {

  private static final int MOVEABLE_CRITERIA = 4;
  private final RandomNumberGenerator generator;

  public RandomMovingStrategy(RandomNumberGenerator generator) {
    this.generator = generator;
  }

  @Override
  public boolean moveable() {
    return generator.generateRandomNumber() >= MOVEABLE_CRITERIA;
  }
}
