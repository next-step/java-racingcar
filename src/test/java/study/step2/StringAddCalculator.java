package study.step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  private static final int DEFAULT_RESULT_VALUE = 0;
  private static final String DEFAULT_SEPARATOR = ",|:";
  private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\\n(.*)"); // '//'와 '\n' 사이의 문자를 의미

  private static final String IS_NOT_NUMBER_FORMAT = "숫자 형식이 올바르지 않습니다. input: %s, errorMessage: %s";
  private static final String UNEXPECTED_ERROR = "예기치 못한 에러가 발생했습니다. input: %s, errorMessage: %s";
  private static final String NEGATIVE_NUMBER_IS_NOT_ALLOWED = "음수는 허용되지 않습니다. input: %s";

  private StringAddCalculator() {
    throw new AssertionError();
  }

  public static int splitAndSum(String given) {

    if (isNullOrEmpty(given)) {
      return DEFAULT_RESULT_VALUE;
    }

    String[] stringArrays = split(given);
    int[] intArrays = toInts(stringArrays);
    return getSum(intArrays);
  }

  public static int getDefaultResult() {
    return DEFAULT_RESULT_VALUE;
  }

  private static boolean isNullOrEmpty(String str) {
    return str == null || str.length() == 0;
  }

  private static int getSum(int[] arrays) {
    return Arrays.stream(arrays).sum();
  }

  private static int[] toInts(String[] arrays) {
    int[] results = new int[arrays.length];

    for (int i = 0; i < arrays.length; i++) {
      toInt(arrays, results, i); // 변환 작업
      checkIsNegativeNumber(results[i]); // 음수 예외
    }

    return results;
  }

  private static void toInt(String[] arrays, int[] results, int index) {
    try {
      results[index] = Integer.parseInt(arrays[index]);
    } catch (NumberFormatException nx) {
      throw new NumberFormatException(String.format(IS_NOT_NUMBER_FORMAT, arrays[index], nx.getMessage()));
    } catch (Exception e) {
      throw new RuntimeException(String.format(UNEXPECTED_ERROR, arrays[index], e.getMessage()), e);
    }
  }

  private static void checkIsNegativeNumber(int number) {
    if (number < 0) {
      throw new IllegalArgumentException(String.format(NEGATIVE_NUMBER_IS_NOT_ALLOWED, number));
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
