package study.step3.domain;

import study.step3.validator.RandomNumber;

public class CarMovableStrategy implements MovableStrategy {

  private static final int MOVE_CONDITION_NUM = 4;

  @Override
  public boolean isMovable(int conditionNumber) {
    return conditionNumber >= MOVE_CONDITION_NUM;
  }

  @Override
  public int generateMoveNUmber() {
    return RandomNumber.generator();
  }

}
