package stringcalculator;

public class StringUtils {

  private StringUtils() {
  }

  public static boolean isBlankString(String string) {
    return string == null || string.trim().isEmpty();
  }

  public static String[] split(String expression) {
    return expression.split(" ");
  }
}
