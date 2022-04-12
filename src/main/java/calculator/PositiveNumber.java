package calculator;

public class PositiveNumber {

  private static final int MIN_VALUE = 0;

  private int number;

  public PositiveNumber(String value) {
    int parsedValue = Integer.parseInt(value);
    if (parsedValue < MIN_VALUE) {
      throw new RuntimeException("음수는 허용되지 않습니다.");
    }
    this.number = parsedValue;
  }

  public int add(int target) {
    return target + this.number;
  }
}
