package calculator;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

  private static final String DEFAULT_SPLIT_PATTERN = "[,:]";
  private static final Pattern COMPILED_PATTERN = Pattern.compile("//(.)\n(.*)");
  private static final int FIRST_MATCHED_GROUP = 1;
  private static final int SECOND_MATCHED_GROUP = 2;

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
      String delim = matcher.group(FIRST_MATCHED_GROUP);
      String input = matcher.group(SECOND_MATCHED_GROUP);
      return input.split(delim);
    }
    return text.split(DEFAULT_SPLIT_PATTERN);
  }

  private static int summingInt(Collection<UnsignedNumber> numbers) {
    return numbers.stream().reduce(new UnsignedNumber("0"), UnsignedNumber::sum).intValue();
  }

  private static Collection<UnsignedNumber> toPositiveNumbers(String[] values) {
    return Arrays.stream(values).map(UnsignedNumber::new).collect(Collectors.toList());
  }
}
