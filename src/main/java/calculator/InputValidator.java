package calculator;

public class InputValidator {

  public void validateInput(String input) {
    if (input.isEmpty() || isBlank(input)) {
      throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자입니다.");
    }
  }

  public boolean isBlank(String input) {
    return input.equals(" ");
  }

}
