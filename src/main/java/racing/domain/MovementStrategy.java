package racing.domain;

import java.util.Random;

public class MovementStrategy {

  private final int MIN_VALUE;
  private final int MAX_VALUE;

  public MovementStrategy(int minMove, int maxMove) {
    this.MIN_VALUE = minMove;
    this.MAX_VALUE = maxMove;
  }

  public int generate() {
    Random random = new Random();
    return random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
  }

}
