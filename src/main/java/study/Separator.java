package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 책임
 * - 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
 *
 */
public class Separator {

  private final String DEFAULT_DELIMITER = ",|:";
  private final String CUSTOM_DELIMITER = "//(.)\n(.*)";

  public String[] split(String text) {

    if (isBlank(text)) {
      return new String[]{"0"};
    }

    return separate(text);
  }

  private String[] separate(String text) {
    Matcher m = getMatcher(text);
    if (m.find()) {
      String customDelimiter = findCustomDelimiter(m);
      return findValue(m, customDelimiter);
    }

    return text.split(DEFAULT_DELIMITER);
  }

  private Matcher getMatcher(String text) {
    return Pattern.compile(CUSTOM_DELIMITER).matcher(text);
  }

  private String[] findValue(Matcher m, String customDelimiter) {
    return m.group(2).split(customDelimiter);
  }

  private static String findCustomDelimiter(Matcher m) {
    return m.group(1);
  }


  private boolean isBlank(String text) {
    return text == null || text.isEmpty();
  }


}
