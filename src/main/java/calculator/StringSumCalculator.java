package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {

  public static int sum(String input) {

    if (isEmptyString(input)) {
      return 0;
    }

    // java.util.regex 패키지의 Matcher, Pattern import
    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
    if (!m.find()) {
      String[] numbers = input.split(",|:");
      return sumNumbers(input, numbers);
    }

    String customDelimiter = m.group(1);
    String[] numbers= m.group(2).split(customDelimiter);

    // 덧셈 구현
    return sumNumbers(input, numbers);
  }

  private static int sumNumbers(String input, String[] numbers) {

    if (numbers.length == 1) {
      return parseNumberToInt(numbers[0]);
    }

    int sum = 0;
    for(String number: numbers) {
      sum += parseNumberToInt(number);
    }
    return sum;
  }

  private static int parseNumberToInt(String number) {

    int intNumber = Integer.parseInt(number);
    isNegativeNumberCheck(intNumber);

    return intNumber;
  }

  private static void isNegativeNumberCheck(int intNumber) {

    if (intNumber < 0) {
      throw new RuntimeException();
    }
  }

  private static boolean isEmptyString(String input) {
    return input == null || input.isEmpty();
  }
}
