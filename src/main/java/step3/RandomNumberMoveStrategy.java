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
    return 4 >= RANDOM.nextInt(10);
  }

  public static MoveStrategy of () {
    return new RandomNumberMoveStrategy();
  }
}
