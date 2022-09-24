package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  public static final String SEPERATOR = ",|:";
  public static final Pattern REGEX_SEPERATOR = Pattern.compile("//(.)\n(.*)");

  public static int splitAndSum(String text) {
    if (isBlank(text)) {
      return 0;
    }
    return sum(toInts(split(text)));
  }

  private static String[] split(String text) {
    Matcher m = REGEX_SEPERATOR.matcher(text);
    String customDelimiter = SEPERATOR;
    if (m.find()) {
      customDelimiter += "|" + m.group(1);
      text = m.group(2);
    }
    return text.split(customDelimiter);
  }

  private static boolean isBlank(String text) {
    return text == null || text.isBlank();
  }

  private static int sum(int[] numbers) {
    int result= 0;
    for (int number : numbers) {
      result += number;
    }
    return result;
  }

  private static int[] toInts(String[] values) {
    int[] numbers = new int[values.length];
    for (int i = 0; i < values.length; i++) {
      numbers[i] = toPositive(values[i]);
    }
    return numbers;
  }

  private static int toPositive(String values) {
    int number = Integer.parseInt(values);
    if (number < 0) {
      throw new RuntimeException("음수 값이 들어올 수 없습니다.");
    }
    return number;
  }
}
