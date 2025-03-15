package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

  public static final String DEFAULT_DELIMITER = ",|:";
  public static final String REGEX = "//(.)\n(.*)";

  public static int calculate(String text) {

    if (isBlank(text)) {
      return 0;
    }
    return sum(toInts(split(text)));
  }

  private static boolean isBlank(String text) {
    return text == null || text.isBlank();
  }

  private static String[] split(String text) {
    if (hasCustomDelimiter(text)) {
      return splitWithCustomDelimiter(text);
    }

    return splitWithDefaultDelimiter(text);
  }

  private static boolean hasCustomDelimiter(String text) {
    return text.startsWith("//");
  }

  private static String[] splitWithDefaultDelimiter(String text) {
    return text.split(DEFAULT_DELIMITER);
  }

  private static String[] splitWithCustomDelimiter(String text) {
    Matcher matcher = Pattern.compile(REGEX).matcher(text);
    if (matcher.find()) {
      return matcher.group(2).split(matcher.group(1));
    }
    return text.split(DEFAULT_DELIMITER);
  }

  private static int[] toInts(String[] values) {
    int[] numbers = new int[values.length];
    for (int i = 0; i < values.length; i++) {
      numbers[i] = toInt(values[i]);
    }
    return numbers;
  }

  private static int toInt(String value) {
    int number = Integer.parseInt(value);
    if (number < 0) {
      throw new RuntimeException("음수를 허용하지 않습니다");
    }
    return number;
  }

  private static int sum(int[] numbers) {
    int result = 0;
    for (int number : numbers) {
      result += number;
    }
    return result;
  }
}
