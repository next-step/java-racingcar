package step3.domain;

import step3.RacingRule;

public class TestAllTrueRacingRule implements RacingRule {

  @Override
  public boolean canMove(int targetNumber) {
    return true;
  }

  @Override
  public int getTargetNumber() {
    return 0;
  }
}
