package study.racing;

public class NumberConditionMoveStrategy implements MoveStrategy {

  private static final int MOVE_CONDITION = 4;

  @Override
  public boolean isMove() {
    int randomNumber = RandomNumberAssigner.getRandomNumber();
    return isMove(randomNumber);
  }

  @Override
  public boolean isMove(int number) {
    if (number >= MOVE_CONDITION) {
      return true;
    }
    return false;
  }
}
