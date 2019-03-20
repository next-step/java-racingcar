package racing;

public class TestRandomGenerator extends RandomGenerator {

  private static final int MOVE_RANGE = 10;

  private boolean movingResult;

  TestRandomGenerator(boolean movingResult) {
    super(MOVE_RANGE);
    this.movingResult = movingResult;
  }

  @Override
  public boolean isMoving(int minNumber) {
    return movingResult;
  }
}
