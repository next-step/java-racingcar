package util;

public final class StringUtils {

  public static String removalParentheses(String input) {
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
}
