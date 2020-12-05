package step3.domain;

import step3.RacingRule;

public class TestAllFalseRacingRule implements RacingRule {

  @Override
  public boolean canMove(int targetNumber) {
    return false;
  }

  @Override
  public int getTargetNumber() {
    return 0;
  }
}
