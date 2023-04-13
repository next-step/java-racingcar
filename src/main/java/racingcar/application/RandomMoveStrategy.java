package racingcar.application;

public class RandomMoveStrategy implements MoveStrategy {

  private static int BOUNDARY = 4;

  private final Accelerator accelerator;

  public RandomMoveStrategy(Accelerator accelerator) {
    this.accelerator = accelerator;
  }

  @Override
  public int move() {
    return accelerator.accelerate() >= BOUNDARY ? 1 : 0;
  }
}
