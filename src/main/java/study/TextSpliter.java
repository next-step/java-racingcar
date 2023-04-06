package study;

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
    return getText().split(delimiters);
  }

  private String getDelimiters() {
    Matcher matcher = DEFAULT_PATTERN.matcher(getText());
    if (matcher.find()) {
      setText(matcher.group(2));
      return DEFAULT_DELIMITERS + "|" + matcher.group(1);
    } else {
      return DEFAULT_DELIMITERS;
    }
  }

  private String getText() {
    return this.text;
  }

  private void setText(String text) {
    this.text = text;
  }
}
