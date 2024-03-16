package racingcar.step4.domain.strategy;

public class RandomCarMoveStrategy implements CarMoveStrategy {

  private static final int BOUND = 10;
  private static final int MEET_CONDITION_FOR_MOVEMENT = 4;
  private static final String THIS_STRATEGY_IS_NOT_REPLICABLE = "복사가 불가능한 전략입니다.";

  public RandomCarMoveStrategy() {}

  @Override
  public boolean isMovable(MoveNumberGenerator moveNumberGenerator) {
    return moveNumberGenerator.generate(BOUND) >= MEET_CONDITION_FOR_MOVEMENT;
  }

  public static RandomCarMoveStrategy copy(CarMoveStrategy strategy) {
    if (strategy instanceof RandomCarMoveStrategy) {
      return new RandomCarMoveStrategy();
    }
    throw new IllegalArgumentException(THIS_STRATEGY_IS_NOT_REPLICABLE);
  }
}
