package carracing.domain.entity;

public class Step {

  private static final int INIT_COUNT = 1;

  private Number step;

  public Step() {
    this.step = new Number(INIT_COUNT);
  }

  public void plus() {
    step.plus();
  }

  public int getValue() {
    return this.step.getValue();
  }
}
