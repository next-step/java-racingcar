package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InputContext {
  private static final String DEFAULT_DELIMITER = "[:,]";
  private static final String DELIMITER_REGEX = "//(.)\n(.*)";

  private final String delimiter;
  private final String content;

  private InputContext(String delimiter, String content){
    this.delimiter = delimiter;
    this.content = content;
  }

  static InputContext parse(String input){
    Matcher m = Pattern.compile(DELIMITER_REGEX).matcher(input);
    if (m.find()) {
      String customDelimiter = m.group(1);
      String content = m.group(2);
      return new InputContext(customDelimiter, content);
    }
    return new InputContext(DEFAULT_DELIMITER, input);
  }

  String[] split(){
    return content.split(delimiter);
  }
}
