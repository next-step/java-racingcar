package carracing.domain.entity;

public class Round {

  private static final String ERROR_MESSAGE = "입력값이 null입니다.";

  private Number number;

  public Round(Number number) {
    if (!isValidInput(number)) {
      throw new IllegalArgumentException(ERROR_MESSAGE);
    }
    this.number = number;
  }

  private boolean isValidInput(Number round) {
    return round != null && round.isGreaterThanZero();
  }

  public boolean hasMoreChance() {
    return this.number.isGreaterThanZero();
  }

  public int getRound() {
    return this.number.getValue();
  }

  public Round minus() {
    if (number.isGreaterThanZero()) {
      number.minus();
    }
    return this;
  }
}
