package step2;

public class PositiveNumber {
  private int value;

  public PositiveNumber(String stringValue) {
    this.value = Integer.parseUnsignedInt(stringValue);
  }

  public PositiveNumber(Integer intValue) {
    if (intValue < 0) {
      throw new IllegalArgumentException("negative value not allowed");
    }
    this.value = intValue;
  }

  public Integer sumInt(final Integer value) {
    return this.value + value;
  }

  public static PositiveNumber sum(PositiveNumber p1, PositiveNumber p2) {
    return new PositiveNumber(p1.value + p2.value);
  }

  public PositiveNumber add(PositiveNumber pInt) {
    this.value += pInt.value;
    return this;
  }

  public Integer getValue() {
    return this.value;
  }
}
