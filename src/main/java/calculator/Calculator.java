package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

  private static final String DEFAULT_DELIMITER = "[,:]";

  private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

  public static int calculate(String targetString) {
    if (isNullOfEmpty(targetString)) {
      return 0;
    }
    return sumInts(parseToInts(splitWithDelimiter(targetString)));
  }

  private static int[] parseToInts(String[] tokens) {
    int[] result = new int[tokens.length];
    for (int i = 0; i < tokens.length; i++) {
      result[i] = parseToInt(tokens[i]);
    }
    return result;
  }

  private static String[] splitWithDelimiter(String targetString) {
    Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(targetString);
    if (matcher.find()) {
      String customDelimiter = Pattern.quote(matcher.group(1));
      return matcher.group(2).split(customDelimiter);
    }
    return targetString.split(DEFAULT_DELIMITER);
  }

  private static int sumInts(int[] tokens) {
    int result = 0;
    for (int addNumber : tokens) {
      validateMinus(addNumber);
      result += addNumber;
    }
    return result;
  }

  private static boolean isNullOfEmpty(String targetString) {
    return targetString == null || targetString.isEmpty();
  }

  private static int parseToInt(String input) {
    try {
      int number = Integer.parseInt(input);
      validateMinus(number);
      return number;
    } catch (NumberFormatException e) {
      throw new RuntimeException("숫자가 아닌 값입니다.");
    }
  }

  private static void validateMinus(int targetNumber) {
    if (targetNumber < 0) {
      throw new RuntimeException("연산 대상 숫자가 음수입니다.");
    }
  }
}