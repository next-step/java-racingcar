package racing.strategy;

public class NumberCompareMoveStrategy implements MoveStrategy {

  private final NumberGenerator numberGenerator;
  private static final int CAN_MOVE_NUMBER = 4;

  public NumberCompareMoveStrategy(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  @Override
  public boolean canMove() {
    return numberGenerator.generate() >= CAN_MOVE_NUMBER;
  }
}
