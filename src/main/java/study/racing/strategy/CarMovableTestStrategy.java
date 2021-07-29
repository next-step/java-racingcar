package study.racing.strategy;

import java.util.List;
import study.racing.generator.Generator;
import study.racing.generator.MakeNumberGenerator;

public class CarMovableTestStrategy implements MoveStrategy{

  private static final int LIMIT_NUMBER = 4;

  private Generator generator;

  public CarMovableTestStrategy(List<Integer> numbers) {
    generator = new MakeNumberGenerator(numbers);
  }

  @Override
  public boolean movable() {
    return generator.generateNewNumber() > LIMIT_NUMBER;
  }
}
