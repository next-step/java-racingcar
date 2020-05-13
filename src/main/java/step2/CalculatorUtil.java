package step2;

public class CalculatorUtil {

  public static boolean isNumber(String input) {
    try {
      Integer.parseInt(input);
      return true;
    } catch (NumberFormatException ne) {
      return false;
    }
  }

  public static void checkNullAndEmpty(String input) {
    if ("".equals(input) || null == input) {
      throw new IllegalArgumentException("공백 혹은 null 값이 입력되었습니다.");
    }
  }

  public static String checkOperator(String input) {
    if (!("+".equals(input) || "-".equals(input) || "/".equals(input) || "*"
        .equals(input))) {
      throw new IllegalArgumentException("잘못된 연산기호가 입력되었습니다 -> " + input);
    }
    return input;
  }

}
