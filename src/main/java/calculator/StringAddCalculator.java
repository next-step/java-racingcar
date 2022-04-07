package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {

  private static final String DEFAULT_SPLIT_PATTERN = "[,:]";
  private static final Pattern COMPILED_PATTERN = Pattern.compile("//(.)\n(.*)");

  /**
   * 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
   *
   * @param text ex) 1,2:3
   * @return ex) 6
   */
  public static int splitAndSum(String text) {
    if (isBlank(text)) {
      return 0;
    }
    String[] values = split(text);
    return summingInt(toPositiveNumbers(values));
  }

  private static boolean isBlank(String text) {
    return text == null || text.isBlank();
  }

  private static String[] split(String text) {
    Matcher matcher = COMPILED_PATTERN.matcher(text);
    if (matcher.find()) {
      String delim = matcher.group(1);
      String input = matcher.group(2);
      return input.split(delim);
    }
    return text.split(DEFAULT_SPLIT_PATTERN);
  }

  private static int summingInt(Stream<UnsignedNumber> numbers) {
    return numbers.reduce(new UnsignedNumber("0"), UnsignedNumber::sum).intValue();
  }

  private static Stream<UnsignedNumber> toPositiveNumbers(String[] values) {
    return Arrays.stream(values).map(UnsignedNumber::new);
  }
}
