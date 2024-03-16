package racingcar.domain;

public class Condition {
  private final int value;

  public Condition(final int value) {
    this.value = value;
  }

  public boolean equalOrLargerThan(int criteria) {
    return this.value >= criteria;
  }
}
