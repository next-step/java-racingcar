package study.step2;

import java.util.regex.Pattern;

public class DelimiterManager {

  private static final String DEFAULT_DELIMITERS = ",|:";
  private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

  public static String[] split(String value) {
    if (!value.startsWith("//")) {
      return value.split(DEFAULT_DELIMITERS);
    }

    CustomMatcher matcher = new CustomMatcher.Builder().matcher(Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(value)).build();
    matcher.findCustomDelimiter();
    String customDelimiter = matcher.group(1);
    String[] numbers = matcher.group(2).split(customDelimiter);
    return numbers;
  }

}
