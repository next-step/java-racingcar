package calculator;

import java.util.Arrays;

public class StringCalculator {

  public static int calculate(String textNumbers, String delimiter) {
    if (isBlank(textNumbers)) {
      return 0;
    }

    int[] numbers = getIntegerList(textNumbers, delimiter);
    return Arrays.stream(numbers).sum();
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
