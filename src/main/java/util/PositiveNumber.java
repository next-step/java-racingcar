package util;

public class PositiveNumber {
  private final int value;

  private PositiveNumber(int value) {
    this.value = value;
  }

  public static PositiveNumber fromInt(int value) {
    if (value < 0) {
      throw new IllegalArgumentException("please set number greater than 0");
    }
    return new PositiveNumber(value);
  }

  public int getValue() {
    return value;
  }
}
