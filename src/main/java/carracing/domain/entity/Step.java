package carracing.domain.entity;

public class Step {

  private static final int INIT_COUNT = 1;
  private static final String MORE_THAN_ZERO = "0이상의 Number가 필요합니다.";

  private Number step;

  public Step() {
    this.step = new Number(INIT_COUNT);
  }

  public Step(Number number) {
    validNaturalNumber(number);
    this.step = number;
  }

  private void validNaturalNumber(Number number) {
    if(number.isLessThanZero()) {
      throw new IllegalArgumentException(MORE_THAN_ZERO);
    }
  }

  public void plus() {
    step.plus();
  }

  public int getValue() {
    return this.step.getValue();
  }

  public boolean isEqualTo(Step step) {
    return this.step.getValue() == step.getValue();
  }
}
