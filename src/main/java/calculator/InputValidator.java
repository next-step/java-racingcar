package calculator;

public class InputValidator {

  public static void validateInput(String input) {
    if (isEmpty(input) || isBlank(input)) {
      throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자입니다.");
    }
  }

  public static boolean isEmpty(String input) {
    return "".equals(input);
  }

  public static boolean isBlank(String input) {
    return " ".equals(input);
  }

}
