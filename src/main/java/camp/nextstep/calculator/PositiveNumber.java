package camp.nextstep.calculator;

import static java.lang.Integer.*;

public class PositiveNumber {

  private final int number;

  public PositiveNumber(String number) {
    this(parseInt(number));
  }

  public PositiveNumber(int number) {
    if (number < 0) {
      throw new RuntimeException("음수를 허용하지 않습니다.");
    }
    this.number = number;
  }

  public int getNumber() {
    return number;
  }
}
