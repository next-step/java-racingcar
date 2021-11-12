package carracing.domain.entity;

import carracing.domain.utils.RandomUtils;

public class Car {

  private static final String bar = "-";
  private static final String CONSTRUCT_ERROR_MESSAGE = "round가 null입니다.";

  private Step nowStep;
  private Round round;

  public Car(Round round) {
    if (round == null) {
      throw new IllegalArgumentException(CONSTRUCT_ERROR_MESSAGE);
    }
    this.nowStep = new Step();
    this.round = round;
  }

  public void move(int standard) {
    if (isValidToMove(standard)) {
      nowStep.plus();
    }
  }

  private boolean isValidToMove(int standard) {
    return round.hasMoreChance() && RandomUtils.isGreaterThanOrEquals(standard);
  }

  public int getNowStep() {
    return this.nowStep.getValue();
  }

  public int getRemainRound() {
    return this.round.getRound();
  }

  public String toStringOfStep() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < nowStep.getValue(); i++) {
      sb.append(bar);
    }
    return sb.toString();
  }
}
