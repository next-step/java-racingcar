package step2;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

  private String expression;
  private int result;

  public StringCalculator expressionScan (String expression) {
    nullValidation(expression);
    blankValidation(expression);
    this.expression = expression;
    return this;
  }

  public int getResult () {
    return this.result;
  }

  public void calculate () {
    String[] token = this.expression.split(" ");
    int x = Integer.parseInt(token[0]);
    for (int i = 1, len = token.length; i < len; i += 2) {
      x = Operation.execute(token[i].charAt(0), x, Integer.parseInt(token[i + 1]));
    }
    this.result = x;
  }

  private void nullValidation (String expression) {
    if (expression == null)
      throw new IllegalArgumentException(CalculatorError.ARGS_NULL);
  }

  private void blankValidation (String expression) {
    if (StringUtils.isBlank(expression))
      throw new IllegalArgumentException(CalculatorError.ARGS_EMPTY);
  }
}
