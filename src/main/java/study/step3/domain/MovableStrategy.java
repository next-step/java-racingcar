package study.step3.domain;

public interface MovableStrategy {
  boolean isMovable(int conditionNumber);

  int generateMoveNUmber();
}
