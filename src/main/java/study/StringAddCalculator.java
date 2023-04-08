package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringAddCalculator {
  private static final int ZERO = 0;
  private static final String RUNTIME_EXCEPTION_MESSAGE = "문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.";

  private static final String ZERO_TO_NONE_REGEX = "^[0-9]*$";
  private static final String DEFAULT_DELIMITER = "[,:]";
  private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

  static int splitAndSum(String text) {
    if (isNullOrEmpty(text)) return 0;

    return sum(toInts(customToStrings(text)));
  }

  private static boolean isNullOrEmpty(String text) {
    return text == null || text.isEmpty();
  }

  private static String[] customToStrings(String text) {
    Matcher matcher = CUSTOM_DELIMITER.matcher(text);

    if (matcher.find()) {
      String customDelimiter = matcher.group(1);

      return matcher.group(2).split(customDelimiter);
    }

    return text.split(DEFAULT_DELIMITER);
  }

  private static int validatedNumber(String text) {
    if (!text.matches(ZERO_TO_NONE_REGEX)) {
      throw new RuntimeException(RUNTIME_EXCEPTION_MESSAGE);
    }

    return Integer.parseInt(text);
  }

  private static int[] toInts(String[] strings) {
    int[] numbers = new int[strings.length];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = validatedNumber(strings[i]);
    }

    return numbers;
  }

  private static int sum(int[] numbers) {
    int total = ZERO;
    for (int number : numbers) {
      total += number;
    }

    return total;
  }
}
