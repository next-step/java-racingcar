package racing.domain;

import racing.util.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy {

  @Override
  public boolean isMovable() {
    int randomNumber = RandomNumberGenerator.generate();
    return CarMoveCondition.isMove(randomNumber);
  }
}
