package racingrefactoring.util;

public class MoveCondition {

  private static final int MOVE_CONDITION = 4;
  public static boolean canMove(int randomNumber) {
    return randomNumber >= MOVE_CONDITION;
  }
}
