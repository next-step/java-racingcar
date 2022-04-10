package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
  public static final String DEFAULT_DELIMITERS = ",|:";

  public static int splitAndSum(String input) {
    if (input == null || input.isBlank()) {
      return 0;
    }
    return calculate(split(input));
  }

  private static String[] split(String input) {
    Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
    if (m.find()) {
      String customDelimiter = m.group(1);
      return m.group(2).split(customDelimiter);
    }
    return input.split(DEFAULT_DELIMITERS);
  }

  private static int calculate(String[] tokens) {
    int result = 0;
    for (String token : tokens) {
      StringNumber number = new StringNumber(token);
      result += number.getNumber();
    }
    return result;
  }
}
