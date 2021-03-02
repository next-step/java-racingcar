package stringcalculator;

public class StringUtils {

  public static final String DELIMITER = " ";

  private StringUtils() {
  }

  public static boolean isBlankString(String string) {
    return string == null || string.trim().isEmpty();
  }

  public static String[] split(String expression) {
    return expression.split(DELIMITER);
  }

  public static boolean isInteger(String token) {
    try {
      Integer.parseInt(token);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
