package calculator;

import java.util.Objects;

/**
 * 0 ~ 2147483647 범위를 갖는 0을 포함하는 자연수
 */
public class UnsignedNumber {

  private static final String EXCEPTION_MESSAGE_FORMAT = "%d 는 Unsigned Number 가 아닙니다.";
  private static final int MINIMUM_VALUE = 0;

  private final int number;

  public UnsignedNumber(String value) throws NumberFormatException, NullPointerException {
    Objects.requireNonNull(value);
    int number = Integer.parseInt(value);
    if (number < MINIMUM_VALUE) {
      throw new NumberFormatException(String.format(EXCEPTION_MESSAGE_FORMAT, number));
    }
    this.number = number;
  }

  private UnsignedNumber(Integer number) {
    assert number != null && number >= 0;
    this.number = number;
  }

  /**
   * 자연수의 값을 int 타입으로 반환한다.
   *
   * @return int 타입의 자연수
   */
  public int intValue() {
    return number;
  }

  /**
   * 두 자연수를 + 연산자로 더한 값을 반환한다.
   *
   * @param a 첫 번째 피연산자
   * @param b 두 번째 피연산자
   * @return a와 b의 합
   */
  public static UnsignedNumber sum(UnsignedNumber a, UnsignedNumber b) {
    Objects.requireNonNull(a);
    Objects.requireNonNull(b);
    return a.plus(b);
  }

  private UnsignedNumber plus(UnsignedNumber unsignedNumber) {
    Objects.requireNonNull(unsignedNumber);
    return new UnsignedNumber(intValue() + unsignedNumber.intValue());
  }
}
