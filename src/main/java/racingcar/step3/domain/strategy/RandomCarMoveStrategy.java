package racingcar.step3.domain.strategy;

public class RandomCarMoveStrategy implements CarMoveStrategy {

  private static final int BOUND = 10;
  private static final int MEET_CONDITION_FOR_MOVEMENT = 4;
  private final RandomNumberGenerator randomNumberGenerator;

  public RandomCarMoveStrategy() {
    this.randomNumberGenerator = new RandomNumberGenerator();
  }

  @Override
  public boolean isMovable() {
    return randomNumberGenerator.generate(BOUND) >= MEET_CONDITION_FOR_MOVEMENT;
  }

  public boolean isMovableTest(int randomNum) {
    return randomNum >= MEET_CONDITION_FOR_MOVEMENT;
  }
}
