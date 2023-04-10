package study.racinggame.util;

public class NumberValidator {

  private static final int POSITIVE_MINIMUM = 1;

  private NumberValidator() {
  }

  public static int validatedPositive(int number) {
    if (!isPositive(number)) {
      throw new IllegalArgumentException("1회 이상만 입력 가능합니다.");
    }

    return number;
  }

  private static boolean isPositive(int number) {
    return number >= POSITIVE_MINIMUM;
  }
}
