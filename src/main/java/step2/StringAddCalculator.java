package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  private static final String PATTERN_DELIMETER = "//(.)\n(.*)";
  private static final String DEFAULT_DELIMETER = ",|:";

  private static final Pattern pattern = Pattern.compile(PATTERN_DELIMETER);

  public static int spliteAndSum(String text) {
    if (text == null || text.isBlank()) {
      return 0;
    }

    String[] splitedText = split(text);
    return sum(toPositiveInteger(splitedText));
  }

  private static String[] split(String text) {
    Matcher m = pattern.matcher(text);

    if (m.find()) {
      String customDelimeter = m.group(1);
      return m.group(2).split(customDelimeter);
    }

    return text.split(DEFAULT_DELIMETER);
  }

  private static int sum(PositiveInteger[] positiveIntegers) {
    int result = 0;
    for (PositiveInteger positiveInteger : positiveIntegers) {
      result = positiveInteger.sum(result);
    }
    return result;
  }

  private static PositiveInteger[] toPositiveInteger(String[] values) {
    final int length = values.length;
    PositiveInteger[] positiveIntegers = new PositiveInteger[length];
    for (int i=0; i<length; i++) {
      positiveIntegers[i] = PositiveInteger.createPositiveIntegerByParsingString(values[i]);
    }
    return positiveIntegers;
  }
}
