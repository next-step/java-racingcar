package study;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class StringAddCalculator {
  private static final int CUSTOM_DELIMER = 1;
  private static final int OPERANDS = 2;
  private static final String RUNTIME_EXCEPTION_MESSAGE = "문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.";

  private static final String NUMBER_REGEX = "^[0-9]*$";
  private static final String DEFAULT_DELIMITER_FORMAT = "[,:]";
  private static final Pattern CUSTOM_DELIMITER_FORMAT = Pattern.compile("//(.)\n(.*)");

  static int splitAndSum(String text) {
    if (isNullOrEmpty(text)) return 0;

    return sum(toInts(customToStrings(text)));
  }

  private static boolean isNullOrEmpty(String text) {
    return text == null || text.isEmpty();
  }

  private static String[] customToStrings(String text) {
    Matcher matcher = CUSTOM_DELIMITER_FORMAT.matcher(text);

    if (matcher.find()) {
      String customDelimiter = matcher.group(CUSTOM_DELIMER);

      return matcher.group(OPERANDS).split(customDelimiter);
    }

    return text.split(DEFAULT_DELIMITER_FORMAT);
  }

  private static void validate(String text) {
    if (!text.matches(NUMBER_REGEX)) {
      throw new RuntimeException(RUNTIME_EXCEPTION_MESSAGE);
    }
  }

  private static List<Integer> toInts(String[] strings) {
    return Arrays.stream(strings)
            .peek(StringAddCalculator::validate)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
  }

  private static int sum(List<Integer> numbers) {
    return numbers.stream()
            .mapToInt(Integer::intValue)
            .sum();
  }
}
