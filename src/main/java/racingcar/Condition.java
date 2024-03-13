package racingcar;

public class Condition {
  private final int value;

  public Condition(final int value) {
    this.value = value;
  }

  boolean equalOrLargerThan(int criteria) {
    return this.value >= criteria;
  }
}
