package calculator.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitUtil {
  private static final String DEFAULT_SPLITTER = "[,:]";
  private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

  public static List<String> splitStringIntoList(String input) {
    Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
    if (m.find()) {
      return List.of(m.group(2).split(m.group(1)));
    }
    return List.of(input.split(DEFAULT_SPLITTER));
  }
}
