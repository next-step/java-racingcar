package calculator;

import java.util.Arrays;

public class StringCalculator {

  public static int calculate(String textNumbers) {
    if (isBlank(textNumbers)) {
      return 0;
    }

    if ((textNumbers.contains(","))) {
      String[] numbers = textNumbers.split(",");
      return Arrays.stream(numbers)
          .mapToInt(Integer::parseInt)
          .sum();
    }

    return Integer.parseInt(textNumbers);
  }

  private static boolean isBlank(String text) {
    return text == null || text.isEmpty();
  }
}
