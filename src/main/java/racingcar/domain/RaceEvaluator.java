package racingcar.domain;

import java.util.Random;

public class RaceEvaluator {

  private static final int DO_MOVE = 4;
  private static final int BOUND = 10;
  private final Random random;

  public RaceEvaluator(Random random) {
    this.random = random;
  }

  public RaceEvaluator() {
    this(new Random());
  }

  public boolean evaluate() {
    return random.nextInt(BOUND) >= DO_MOVE;
  }
}
