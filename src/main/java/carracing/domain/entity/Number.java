package carracing.domain.entity;

public class Number {

  private static final int ZERO = 0;

  private int number;

  public Number(int number) {
    this.number = number;
  }

  public Number plus() {
    return new Number(++this.number);
  }

  public Number minus() {
    return new Number(--this.number);
  }

  public boolean isGreaterThanZero() {
    return this.number > ZERO;
  }

  public int getValue() {
    return this.number;
  }
}
