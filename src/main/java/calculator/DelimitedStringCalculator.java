package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimitedStringCalculator {

  private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
  private static final String DEFAULT_DELIMITER_REGEX = "^[0-9,:]+$";

  private DelimitedStringCalculator() {

  }

  public static int sum(String input) {
    if (isNotValidString(input)) {
      return 0;
    }

    if (hasCustomDelimiter(input)) {
      return sumNonNegativeNumberWithCustomDelimiter(input);
    }

    if (hasDefaultDelimiter(input)) {
      return sumNonNegativeNumberWithDefaultDelimiter(input);
    }

    return convertStringToNumber(input);
  }

  private static boolean isNotValidString(String input) {
    return input == null || input.isEmpty();
  }

  private static boolean hasCustomDelimiter(String input) {
    Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);

    return matcher.matches();
  }

  private static int sumNonNegativeNumberWithCustomDelimiter(String input) {
    Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);

    if (m.matches()) {
      String customDelimiter = m.group(1);

      int[] numbers = convertStringsToNumbers(m.group(2).split(Pattern.quote(customDelimiter)));
      if (hasNegativeNumber(numbers)) {
        throw new IllegalArgumentException(String.format(
            "음수는 연산할 수 없습니다. - %s",
            input
        ));
      }

      return sumNumbers(numbers);
    }

    throw new IllegalArgumentException(String.format(
        "커스텀 구분자가 들어가있는 문자열 형태가 아닙니다. - %s",
        input
    ));
  }

  private static boolean hasDefaultDelimiter(String input) {
    Matcher m = Pattern.compile(DEFAULT_DELIMITER_REGEX).matcher(input);

    return m.find();
  }

  private static int sumNonNegativeNumberWithDefaultDelimiter(String input) {
    Matcher m = Pattern.compile(DEFAULT_DELIMITER_REGEX).matcher(input);

    if (!m.matches()) {
      throw new IllegalArgumentException(String.format(
          "커스텀 구분자 입력을 받지 않으면 구분자는 \",\" 혹은 \":\" 구분자만 사용 가능합니다. - %s",
          input
      ));
    }

    int[] numbers = convertStringsToNumbers(input.split("[,:]"));
    if (hasNegativeNumber(numbers)) {
      throw new IllegalArgumentException(String.format(
          "음수는 연산할 수 없습니다. - %s",
          input
      ));
    }

    return sumNumbers(numbers);
  }

  private static boolean hasNegativeNumber(int[] numbers) {
    for (int number : numbers) {
      if (number < 0) {
        return true;
      }
    }
    return false;
  }

  private static int[] convertStringsToNumbers(String[] values) {
    int[] numbers = new int[values.length];

    for (int i = 0; i < values.length; i++) {
      numbers[i] = convertStringToNumber(values[i]);
    }

    return numbers;
  }

  private static int convertStringToNumber(String value) {
    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(String.format(
          "유효하지 않는 숫자 형식의 문자가 문자열에 있습니다. - %s ",
          value
      ), e);
    }
  }

  private static int sumNumbers(int[] numbers) {
    int sum = 0;

    for (int number : numbers) {
      sum += number;
    }

    return sum;
  }
}
