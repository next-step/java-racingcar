package calculator;

import java.util.Arrays;

public class StringCalculator {

  public static int calculate(String textNumbers, String delimiter) {
    if (isBlank(textNumbers)) {
      return 0;
    }

    int[] numbers = getIntegerList(textNumbers, delimiter);

    validatePositiveNumbers(numbers);

    return Arrays.stream(numbers).sum();
  }

  private static void validatePositiveNumbers(int[] numbers) {
    if (Arrays.stream(numbers).anyMatch(n -> n < 0)) {
      throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
    }
  }

  private static int[] getIntegerList(String text, String delimiter) {
    String[] numbers = text.split(delimiter);
    return Arrays.stream(numbers)
        .mapToInt(Integer::parseInt)
        .toArray();
  }

  public static int calculate(String textNumbers) {
    return calculate(textNumbers, ",");
  }

  private static boolean isBlank(String text) {
    return text == null || text.isEmpty();
  }

}
