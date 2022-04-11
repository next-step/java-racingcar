package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

  private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
  private static final String DEFAULT_DELIMITERS = "[,|:]";

  private StringParser() {
  }

  public static String[] split(String input) {
    Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
    if (m.find()) {
      String customDelimiter = m.group(1);
      return m.group(2).split(customDelimiter);
    }
    return input.split(DEFAULT_DELIMITERS);
  }
}
