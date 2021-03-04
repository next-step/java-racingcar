package calculator;

public class NumberValidator {

  public static boolean isNumber(String val) {
    try {
      Integer.parseInt(val);
      return true;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }
}
