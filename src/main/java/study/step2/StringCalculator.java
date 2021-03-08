package study.step2;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

  private static final String BLANK = " ";

  public int calculate(String expression) {
    checkBlank(expression);
    String[] splitExpression = expression.split(BLANK);
    return calculateExpression(splitExpression);
  }

  private void checkBlank(String expression) {
    if (StringUtils.isBlank(expression)) {
      throw new IllegalArgumentException("number is blank");
    }
  }

  private int calculateExpression(String[] splitExpression) {
    int result = parseInt(splitExpression[0]);
    for (int i = 1; i < splitExpression.length; i += 2) {
      Arithmetic arithmetic = Arithmetic.findByCode(splitExpression[i]);
      int secondNumber = parseInt(splitExpression[i + 1]);
      result = arithmetic.calculate(result, secondNumber);
    }
    return result;
  }

  public int parseInt(String numberString) {
    return Integer.parseInt(numberString);
  }

}
