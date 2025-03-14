package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

  private static final String DEFAULT_DELIMITER = ",|:";
  private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

  public static int calculate(String textNumbers) {
    if (isBlank(textNumbers)) {
      return 0;
    }

    int[] numbers = getIntegerList(textNumbers);

    validatePositiveNumbers(numbers);

    return Arrays.stream(numbers).sum();
  }

  private static void validatePositiveNumbers(int[] numbers) {
    if (Arrays.stream(numbers).anyMatch(n -> n < 0)) {
      throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
    }
  }

  private static int[] getIntegerList(String text) {
    return Arrays.stream(parseNumbers(text))
        .mapToInt(Integer::parseInt)
        .toArray();
  }

  private static String[] parseNumbers(String text) {
    Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
    if (matcher.find()) {
      String customDelimiter = matcher.group(1);
      return matcher.group(2).split(customDelimiter);
    }
    return text.split(DEFAULT_DELIMITER);
  }

  private static boolean isBlank(String text) {
    return text == null || text.isEmpty();
  }

}
