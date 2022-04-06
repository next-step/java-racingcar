package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  public static final String DEFAULT_SPLIT_PATTERN = "[,:]";
  public static final String CUSTOM_SPLIT_PATTERN = "//(.)\n(.*)";

  public static int splitAndSum(String text) {
    if (text == null || text.isBlank()) {
      return 0;
    }
    String[] values = split(text);
    return sum(toNumbers(values));
  }

  private static String[] split(String text) {
    Matcher matcher = Pattern.compile(CUSTOM_SPLIT_PATTERN).matcher(text);
    if (matcher.find()) {
      String delim = matcher.group(1);
      return matcher.group(2).split(delim);
    }
    return text.split(DEFAULT_SPLIT_PATTERN);
  }

  private static int sum(PositiveNumber[] numbers) {
    int sum = 0;
    for (PositiveNumber number : numbers) {
      sum += number.getNumber();
    }
    return sum;
  }

  private static PositiveNumber[] toNumbers(String[] values) {
    PositiveNumber[] numbers = new PositiveNumber[values.length];
    for (int i = 0; i < values.length; i++) {
      numbers[i] = new PositiveNumber(values[i]);
    }
    return numbers;
  }
}
