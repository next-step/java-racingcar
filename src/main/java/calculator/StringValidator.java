package calculator;

import java.util.Arrays;
import java.util.List;

public class StringValidator {

  private static final List<String> FOUR_OPERATOR = Arrays.asList("+", "-", "*", "/");

  public static boolean isNumber(String val) {
    try {
      Integer.parseInt(val);
      return true;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }

  public static boolean isOperator(String val) {
    return FOUR_OPERATOR.contains(val);
  }

  public static boolean isBlank(String val) {
    return val == null || val.trim().isEmpty();
  }

}
