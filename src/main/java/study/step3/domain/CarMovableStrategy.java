package study.step3.domain;


import study.step3.validator.RandomNumber;

public class CarMovableStrategy implements MovableStrategy {

  private static final int MOVE_CONDITION_NUM = 4;

  @Override
  public boolean isMovable() {
    return RandomNumber.generator() >= MOVE_CONDITION_NUM;
  }

}
