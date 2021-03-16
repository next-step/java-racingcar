package study.racing.domain;

import study.racing.utils.RandomNumberAssigner;

public class NumberConditionMoveStrategy implements MoveStrategy {

  private static final int MOVE_CONDITION = 4;

  @Override
  public boolean isMove() {
    int randomNumber = RandomNumberAssigner.getRandomNumber();
    return isMove(randomNumber);
  }
  public boolean isMove(int number) {
    if (number >= MOVE_CONDITION) {
      return true;
    }
    return false;
  }
}
