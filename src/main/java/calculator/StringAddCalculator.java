package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  private static final String SPLIT_REGEX = ",|:";
  private static final String ESCAPE_LETTERS = "?*[+{}()^$";
  private static final Pattern CUSTOM_SPLIT_LETTER = Pattern.compile("//(.)\n(.*)");

  public int calculate(String inputText) {
    if (isBlank(inputText)) {
      return 0;
    }

    return sum(splitNumbers(inputText));
  }

  private boolean isBlank(String inputText) {
    return inputText == null || inputText.isEmpty();
  }

  private int sum(String[] numbers) {
    int sum = 0;
    for (String number : numbers) {
      sum += toInt(number);
    }

    return sum;
  }

  private int toInt(String number) {
    int intNumber = Integer.parseInt(number);
    if (intNumber < 0) {
      throw new RuntimeException("음수는 계산 지원하지 않습니다");
    }

    return intNumber;
  }

  private String[] splitNumbers(String inputText) {
    Matcher m = CUSTOM_SPLIT_LETTER.matcher(inputText);
    if (m.find()) {
      return m.group(2).split(customDelimiter(m));
    }

    return inputText.split(SPLIT_REGEX);
  }

  private String customDelimiter(Matcher m) {
    String delimiter = m.group(1);
    if (ESCAPE_LETTERS.contains(delimiter)) {
      return "\\" + delimiter;
    }

    return m.group(1);
  }
}
