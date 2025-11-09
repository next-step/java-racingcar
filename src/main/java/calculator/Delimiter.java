package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Delimiter {
  private static final String DEFAULT_DELIMITER = "[:,]";
  private static final String DELIMITER_REGEX = "//(.)\n(.*)";

  private final String delimiter;
  private final String content;

  private Delimiter(String delimiter, String content){
    this.delimiter = delimiter;
    this.content = content;
  }

  static Delimiter parse(String input){
    Matcher m = Pattern.compile(DELIMITER_REGEX).matcher(input);
    if (m.find()) {
      String customDelimiter = m.group(1);
      String content = m.group(2);
      return new Delimiter(customDelimiter, content);
    }
    return new Delimiter(DEFAULT_DELIMITER, input);
  }

  String[] split(){
    return content.split(delimiter);
  }
}
