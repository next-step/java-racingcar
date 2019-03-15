package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {

  public static int sum(String input) {

    if (isEmptyString(input)) {
      return 0;
    }

    String[] numbers = splitNumberArray(input);
    return sumNumbers(numbers);
  }

  private static String[] splitNumberArray(String input) {

    // java.util.regex 패키지의 Matcher, Pattern import
    Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
    if (!matcher.find()) {
      return input.split("[,:]");
    }

    String customDelimiter = matcher.group(1);
    return matcher.group(2).split(customDelimiter);
  }

  private static int sumNumbers(String[] numbers) {

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
