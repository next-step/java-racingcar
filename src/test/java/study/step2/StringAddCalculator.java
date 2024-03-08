package study.step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  private static final int DEFAULT_RESULT_VALUE = 0;
  private static final String DEFAULT_SEPARATOR = ",|:";
  private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\\n(.*)"); // '//'와 '\n' 사이의 문자를 의미

  public static int splitAndSum(String given) {

    if (isNullOrEmpty(given)) {
      return DEFAULT_RESULT_VALUE;
    }

    String[] stringArrays = split(given);
    validate(stringArrays);
    return getSum(stringArrays);
  }

  public static int getDefaultResult() {
    return DEFAULT_RESULT_VALUE;
  }

  private static boolean isNullOrEmpty(String str) {
    return str == null || str.length() == 0;
  }

  private static int getSum(String[] stringArrays) {
    return Arrays.stream(stringArrays)
        .mapToInt(Integer::parseInt)
        .sum();
  }

  private static void validate(String[] stringArrays) {

    int number = 0;
    for (String str : stringArrays) {

      // 숫자 형식인가?
      try {
        number = Integer.parseInt(str);
      } catch (Exception e) {
        throw new NumberFormatException();
      }

      // 음수가 아닌가?
      if (number < 0) {
        throw new RuntimeException();
      }
    }
  }

  private static String[] split(String text) {
    Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(text);
    if (matcher.find()) {
      String customDelimiter = matcher.group(1);
      return matcher.group(2).split(customDelimiter);
    }
    return text.split(DEFAULT_SEPARATOR);
  }
}
