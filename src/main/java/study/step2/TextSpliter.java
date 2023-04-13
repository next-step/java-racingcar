package study.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextSpliter {

  private static final String DEFAULT_DELIMITERS = ",|:";
  private static final Pattern DEFAULT_PATTERN = Pattern.compile("//(.)\n(.*)");
  private static final int TEXT_IDX = 0;
  private static final int DELIMITERS_IDX = 1;

  public static String[] split(String text) {
    String[] textAnddelimiters = getDelimiters(text);
    return textAnddelimiters[TEXT_IDX].split(textAnddelimiters[DELIMITERS_IDX]);
  }

  private static String[] getDelimiters(String text) {
    Matcher matcher = getMatcher(text);
    if (matcher.find()) {
      return new String[]{matcher.group(2), DEFAULT_DELIMITERS + "|" + matcher.group(1)};
    }
    return new String[]{text, DEFAULT_DELIMITERS};
  }

  private static Matcher getMatcher(String text) {
    return DEFAULT_PATTERN.matcher(text);
  }
}
