package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  private static final String DELIMETER = "//(.)\n(.*)";
  private static final String REGEX = ",|:";

  private static final Pattern pattern = Pattern.compile(DELIMETER);

  public static int spliteAndSum(String text) {
    if (text == null || text.isBlank()) {
      return 0;
    }

    Matcher m = pattern.matcher(text);

    if (m.find()) {
      String customDelimeter = m.group(1);
      String[] tokens = m.group(2).split(customDelimeter);
      return sum(toPositiveInteger(tokens));
    }

    String[] values = text.split(REGEX);
    return sum(toPositiveInteger(values));
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
