package step45.domain;

import step45.utils.RandomValueGenerator;

public class RandomMoveStrategy implements MoveStrategy {

  private final int MOVE_THRESHOLD = 4;

  @Override
  public int getMoveDistance() {
    if (RandomValueGenerator.getRandomNumber() >= MOVE_THRESHOLD) {
      return 1;
    }
    return 0;
  }
}
