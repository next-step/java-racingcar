package racing;

public class TestRandomGenerator extends RandomGenerator {

  boolean movingResult;
  public TestRandomGenerator(boolean movingResult) {
    super(10);
    this.movingResult = movingResult;
  }

  @Override
  public boolean isMoving(int minNumber) {
    return movingResult;
  }
}
