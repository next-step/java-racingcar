package calculator;

import java.util.Objects;

public class NumberWrapper {

  private final int number;
  private final String IMPOSSIBLE_ZERO_MESSAGE = "0으로 나눌 수 없습니다.";

  public NumberWrapper(int number) {
    this.number = number;
  }

  public NumberWrapper(String number) {
    this(Integer.parseInt(number));
  }

  public NumberWrapper sum(NumberWrapper second) {
    return new NumberWrapper(this.number + second.number);
  }

  public NumberWrapper sub(NumberWrapper second) {
    return new NumberWrapper(this.number - second.number);
  }

  public NumberWrapper multiply(NumberWrapper second) {
    return new NumberWrapper(this.number * second.number);
  }

  public NumberWrapper divide(NumberWrapper second) {
    if (second.number == 0) {
      throw new IllegalArgumentException(IMPOSSIBLE_ZERO_MESSAGE);
    }
    return new NumberWrapper(this.number / second.number);
  }

  public int getNumber() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    NumberWrapper that = (NumberWrapper) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }


}
