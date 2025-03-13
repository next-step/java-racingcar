package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
  private static final String DELIMITER = ",|:";
  private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

  public static int splitAndSum(String text) {
    if (isEmptyText(text))
      return 0;
    return sum(toInts(split(text)));
  }

  private static int toInt(String number) {
    int num = Integer.parseInt(number);
    if(num < 0)
      throw new RuntimeException("Negative numbers are not allowed: " + num);
    return num;
  }

  private static int[] toInts(String[] numbers) {
    int[] result = new int[numbers.length];
    for (int i=0; i<numbers.length; i++) {
      result[i] = toInt(numbers[i]);
    }
    return result;
  }

  private static boolean isEmptyText(String text) {
    return text == null || text.isEmpty();
  }

  private static String[] split(String text)  {
    Matcher matcher = PATTERN.matcher(text);
    if (matcher.find()) // custom delimiter 인 경우
      return matcher.group(2).split(matcher.group(1));
    return text.split(DELIMITER);
  }

    private static int sum(int[] numbers) {
      int sum = 0;
      for (int number : numbers) {
        sum += number;
      }
      return sum;
    }

}
