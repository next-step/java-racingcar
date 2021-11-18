package carracing.domain.entity;

public class Number {

  private static final int ZERO = 0;

  private int value;

  public Number(int number) {
    this.value = number;
  }

  public void plus() {
    ++this.value;
  }

  public void minus() {
    --this.value;
  }

  public boolean isGreaterThanZero() {
    return this.value > ZERO;
  }

  public boolean isLessThanZero() {
    return this.value < ZERO;
  }

  public int getValue() {
    return this.value;
  }
}
