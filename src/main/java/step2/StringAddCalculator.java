package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  private static final String DELIMETER = "//(.)\n(.*)";

  public static int spliteAndSum(String text) {
    if (text == null || text.isBlank()) {
      return 0;
    }

    Matcher m = Pattern.compile(DELIMETER).matcher(text);
    if (m.find()) {
      String customDelimeter = m.group(1);
      String[] tokens = m.group(2).split(customDelimeter);
      return sum(tokens);
    }

    String[] values = text.split(",|:");
    return sum(values);
  }

  private static int sum(String[] values) {
    int result = 0;
    for (String value : values) {
      int number = Integer.parseInt(value);;
      if (number < 0) {
        throw new RuntimeException("음수는 변환할 수 없습니다.");
      }
      result += number;
    }
    return result;
  }
}
