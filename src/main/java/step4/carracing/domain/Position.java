package step4.carracing.domain;

public class Position {
  private static final String POSITION_SYMBOL = "-";
  private int value;

  public Position(int value) {
    validate(value);
    this.value = value;
  }

  private void validate(int value) {
    if (value < 0) {
      throw new IllegalArgumentException("위치는 0 이상이어야 합니다.");
    }
  }

  public void increase(int incrementValue) {
    value += incrementValue;
  }

  public boolean isSame(int maxPosition) {
    return value == maxPosition;
  }

  public int getMax(int compareValue) {
    return Math.max(value, compareValue);
  }

  public String getStatus() {
    return POSITION_SYMBOL.repeat(value+1);
  }
}
