package racing.domain;

import racing.util.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy {

  private final int MOVABLE_NUMBER = 4;
  @Override
  public boolean isMovable() {
    int randomNumber = RandomNumberGenerator.generate();
    return CarMoveCondition.isMove(randomNumber);
  }
}
