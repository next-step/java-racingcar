package carracing.domain.entity;

public class Number {

  private static final int ZERO = 0;

  private int number;

  public Number(int number) {
    this.number = number;
  }

  public void plus() {
    ++this.number;
  }

  public void minus() {
    --this.number;
  }

  public boolean isGreaterThanZero() {
    return this.number > ZERO;
  }

  public int getValue() {
    return this.number;
  }
}
