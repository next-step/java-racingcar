package study.step3.domain;

public class CarMovableStrategy implements MovableStrategy {

  private static final int MOVE_CONDITION_NUM = 4;

  public boolean isMovable(int conditionNumber) {
    return conditionNumber >= MOVE_CONDITION_NUM;
  }

}
