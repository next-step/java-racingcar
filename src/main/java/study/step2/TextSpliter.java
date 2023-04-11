package study.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextSpliter {

  private static final String DEFAULT_DELIMITERS = ",|:";
  private static final Pattern DEFAULT_PATTERN = Pattern.compile("//(.)\n(.*)");

  private String text;

  public TextSpliter(String text) {
    this.text = text;
  }

  public String[] split() {
    String delimiters = getDelimiters();
    return this.text.split(delimiters);
  }

  private String getDelimiters() {
    Matcher matcher = getMatcher();
    if (matcher.find()) {
      this.text = matcher.group(2);
      return DEFAULT_DELIMITERS + "|" + matcher.group(1);
    } else {
      return DEFAULT_DELIMITERS;
    }
  }

  private Matcher getMatcher() {
    return DEFAULT_PATTERN.matcher(this.text);
  }
}
