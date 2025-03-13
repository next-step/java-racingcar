package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
  private static final String delimiter = ",|:";

  public static int splitAndSum(String text) throws RuntimeException {
    if (isEmptyText(text))
      return 0;

    return sum(split(text));
    }

  private static boolean isEmptyText(String text) {
    return text == null || text.isEmpty();
  }

  private static String[] split(String text)  {
    Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
    if (matcher.find()) // custom delimiter 인 경우
      return matcher.group(2).split(matcher.group(1));

    return text.split(delimiter);
  }

    private static int sum(String[] numbers) throws RuntimeException {
      int sum = 0;
      for (String value : numbers) {
        int number = Integer.parseInt(value);
        if(number < 0)
          throw new RuntimeException();

        sum += number;
      }
      return sum;
    }

}
