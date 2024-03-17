package racingcar.domain;

public class Criteria {
  private final int min;

  public Criteria(int min) {
    this.min = min;
  }

  public boolean accepts(Condition condition) {
    return condition.equalOrLargerThan(min);
  }
}
