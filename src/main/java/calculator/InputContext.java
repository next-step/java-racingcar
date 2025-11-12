package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InputContext {

  private static final String DEFAULT_DELIMITER = "[:,]";
  private static final String DELIMITER_REGEX = "//(.)\n(.*)";

  private final String delimiter;
  private final String content;

  InputContext(String input) {
    Matcher m = Pattern.compile(DELIMITER_REGEX).matcher(input);
    if (m.find()) {
      this.delimiter = m.group(1);
      this.content = m.group(2);
      return;
    }
    this.delimiter = DEFAULT_DELIMITER;
    this.content = input;
  }

  String[] split() {
    return content.split(delimiter);
  }
}
