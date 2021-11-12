package carracing.domain.entity;

public class Round {

  private static final String ERROR_MESSAGE = "입력값이 null입니다.";

  private Number round;

  public Round(Number round) {
    if (!isValidInput(round)) {
      throw new IllegalArgumentException(ERROR_MESSAGE);
    }
    this.round = round;
  }

  private boolean isValidInput(Number round) {
    return round != null && round.isGreaterThanZero();
  }

  public boolean hasMoreChance() {
    return this.round.isGreaterThanZero();
  }

  public int getRound() {
    return this.round.getValue();
  }

  public Round minus() {
    if (round.isGreaterThanZero()) {
      round.minus();
    }
    return this;
  }
}
