package stringcalculator;

import static stringcalculator.StringUtils.isBlankString;

public class Validator {

  private Validator() {
  }

  public static void validateExpression(String expression) {
    if (isBlankString(expression)) {
      throw new IllegalArgumentException("식을 입력해주세요.");
    }
  }
}
