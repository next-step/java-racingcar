package stringcalculator;

import static stringcalculator.StringUtils.isBlank;

public class Validator {

  private Validator() {
  }

  public static void validateExpression(String expression) {
    if (isBlank(expression)) {
      throw new IllegalArgumentException("식을 입력해주세요.");
    }
  }
}
