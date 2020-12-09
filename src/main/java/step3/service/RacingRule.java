package step3.service;

public interface RacingRule {
  // 전진여부를 결정한다.
  boolean canMove(int targetNumber);

  // 레이싱에서 필요한 숫자 범위를 조회한다.
  int getTargetNumber();
}
