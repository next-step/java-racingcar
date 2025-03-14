package calculator.util;

import java.util.List;

public class StringUtil {

  public static boolean isNullOrEmpty(String input) {
    return input == null || input.isEmpty();
  }

  public static int addNumbersInArray(List<String> numbers) {
    if (isListAllPositiveNumbers(numbers)) {
      return numbers.stream()
              .mapToInt(Integer::parseInt)
              .sum();
    } else {
      throw new IllegalArgumentException("음수 또는 숫자가 아닌 값이 포함되어 있습니다.");
    }
  }

  private static boolean isListAllPositiveNumbers(List<String> numbers) {
    for (String number : numbers) {
      if (!StringUtil.isNumber(number) || StringUtil.isNegative(number)) {
        return false;
      }
    }
    return true;
  }

  private static boolean isNumber(String input) {
    try {
      Integer.parseInt(input);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private static boolean isNegative(String input) {
    try {
      Integer.parseInt(input);
    } catch (NumberFormatException e) {
      return false;
    }
    return isNumber(input) && Integer.parseInt(input) < 0;
  }
}

