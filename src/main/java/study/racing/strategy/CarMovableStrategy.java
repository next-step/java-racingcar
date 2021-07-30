package study.racing.strategy;

import study.racing.generator.Generator;
import study.racing.generator.RandomGenerator;

public class CarMovableStrategy implements MoveStrategy{

  private static final int LIMIT_NUMBER = 4;

  private Generator generator = new RandomGenerator();

  @Override
  public boolean movable() {
    return generator.generateNewNumber() > LIMIT_NUMBER;
  }
}