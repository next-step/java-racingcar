package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringAddCalculator {

  private static final String DELIMITERS = ",|:";
  private static final String PATTERN = "//(.)\n(.*)";

  public static int splitAndSum(String text) {
    if (checkEmptyOrNull(text)) {
      return 0;
    }
    return createTextSpliter(text).sumTokens();
  }

  private static boolean checkEmptyOrNull(String text) {
    if (text == null || text.isEmpty()) {
      return true;
    }
    return false;
  }

  private static Matcher createMatcher(String text) {
    return Pattern.compile(PATTERN).matcher(text);
  }

  private static TextSpliter createTextSpliter(String text) {
    Matcher m = createMatcher(text);
    if (m.find()) {
      return new TextSpliter(m.group(2), DELIMITERS + "|" + m.group(1));
    }
    return new TextSpliter(text, DELIMITERS);
  }
}

class TextSpliter {

  private String text;
  private String delimeters;
  private String[] tokens;

  public TextSpliter(String text, String delimeters) {
    this.text = text;
    this.delimeters = delimeters;
    this.tokens = text.split(delimeters);
  }

  public int sumTokens() {
    return Arrays.stream(tokens).mapToInt(token -> {
      int number = Integer.parseInt(token);
      if (number < 0) {
        throw new RuntimeException("음수가 전달되었습니다.: " + number);
      }
      return number;
    }).sum();
  }
}
