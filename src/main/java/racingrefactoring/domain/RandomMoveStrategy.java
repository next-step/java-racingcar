package racingrefactoring.domain;

import racingrefactoring.util.MoveCondition;
import racingrefactoring.util.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy{

  @Override
  public boolean isMovable() {
    int randomNumber = RandomNumberGenerator.generateNumber();
    return MoveCondition.canMove(randomNumber);
  }
}
