package study.racinggame.util;

public class NumberValidator {

  private static final int POSITIVE_MINIMUM = 1;
  private static final String NUMBER_ILLEGAL_ARGUMENT_EXCEPTION = "1회 이상만 입력 가능합니다.";

  private NumberValidator() {
  }

  public static int validatedPositive(int number) {
    if (!isPositive(number)) {
      throw new IllegalArgumentException(NUMBER_ILLEGAL_ARGUMENT_EXCEPTION);
    }

    return number;
  }

  private static boolean isPositive(int number) {
    return number >= POSITIVE_MINIMUM;
  }
}
