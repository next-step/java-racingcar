package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils {
  private static final Pattern POSITIVE_NUMERIC_PATTEN = Pattern.compile("\\d+(\\.\\d+)?");

  public static String removeParentheses(String input) {
    int startIdx = 1;
    int endIdx = input.length() - 1;
    return input.substring(startIdx, endIdx);
  }

  public static boolean isNotBlank (String input) {
    return !isBlank(input);
  }

  public static boolean isBlank (String input) {
    return input == null || input.isBlank();
  }

  public static boolean isPositiveDigit(String input) {
    Matcher matcher = POSITIVE_NUMERIC_PATTEN.matcher(input);
    return matcher.matches();
  }
}
