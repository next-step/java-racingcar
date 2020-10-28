package study.utils;

public class CheckUtils {

  public static boolean isNumber(String num) {
    try {
      Integer.parseInt(num);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public static boolean isNotNumber(String num) {
    return !isNumber(num);
  }

}
