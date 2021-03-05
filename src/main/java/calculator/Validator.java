package calculator;

public class Validator {

  public void validateInput(String input) {
    if (isEmpty(input) || isBlank(input)) {
      throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자입니다.");
    }
  }

  public boolean isEmpty(String input) {
    return input.equals("");
  }

  public boolean isBlank(String input) {
    return input.equals(" ");
  }

}
