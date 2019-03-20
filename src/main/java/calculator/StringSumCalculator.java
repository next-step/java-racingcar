package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {

  public static int sum(String input) {

    if (isEmptyString(input)) {
      return 0;
    }

    return sumNumbers(splitNumberArray(input));
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

    return Arrays.stream(numbers)
        .mapToInt(StringSumCalculator::parseNumberToInt)
        .sum();
  }

  private static int parseNumberToInt(String number) {

    int intNumber = Integer.parseInt(number);
    if (isNegativeNumber(intNumber)) {
      throw new RuntimeException();
    }

    return intNumber;
  }

  private static boolean isNegativeNumber(int intNumber) {
    return intNumber < 0;
  }

  private static boolean isEmptyString(String input) {
    return input == null || input.isEmpty();
  }
}
