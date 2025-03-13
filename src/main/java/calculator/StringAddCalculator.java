package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
  private static final String DELIMITER = ",|:";
  private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

  public static int splitAndSum(String text) {
    if (isEmptyText(text)) {
      return 0;
    }
    int[] numbers = toInts(split(text));
    return sum(numbers);
  }

  private static int[] toInts(String[] numbers) {
    return Arrays.stream(numbers)
        .mapToInt(StringAddCalculator::toInt)
        .toArray();
  }

  private static int toInt(String number) {
    int num = Integer.parseInt(number);
    if(num < 0) {
      throw new RuntimeException("Negative numbers are not allowed: " + num);
    }
    return num;
  }

  private static boolean isEmptyText(String text) {
    return text == null || text.isEmpty();
  }

  private static String[] split(String text)  {
    Matcher matcher = PATTERN.matcher(text);
    if (matcher.find()) { // custom delimiter 인 경우
      return matcher.group(2).split(matcher.group(1));
    }
    return text.split(DELIMITER);
  }

  private static int sum(int[] numbers) {
    return Arrays.stream(numbers).sum();
  }

}
