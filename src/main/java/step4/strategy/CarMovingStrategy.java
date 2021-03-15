package step4.strategy;

import step4.util.Generator;
import step4.util.RandomGenerator;

public class CarMovingStrategy implements Strategy {

  private static final int MOVING_NUMBER = 4;
  private final Generator generator;

  public CarMovingStrategy() {
    this(new RandomGenerator());
  }

  public CarMovingStrategy(Generator generator){
    this.generator = generator;
  }

  public boolean isMovableWithValue(int randomValue){
    return randomValue >= MOVING_NUMBER;
  }

  @Override
  public boolean isMovable() {
    return this.isMovableWithValue(generator.generate());
  }
}
