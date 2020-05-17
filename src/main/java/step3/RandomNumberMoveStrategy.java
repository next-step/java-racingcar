package step3;

import java.util.Random;

public class RandomNumberMoveStrategy implements MoveStrategy {

  private final Random RANDOM;

  private RandomNumberMoveStrategy() {
    this(new Random());
  }

  private RandomNumberMoveStrategy(final Random RANDOM) {
    this.RANDOM = RANDOM;
  }

  @Override
  public boolean isMoved () {
    return this.isMoved(RANDOM.nextInt(10));
  }

  @Override
  public boolean isMoved (int number) {
    return number >= 4;
  }

  public static MoveStrategy of () {
    return new RandomNumberMoveStrategy();
  }
}
