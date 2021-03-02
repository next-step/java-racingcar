package stringcalculator;

import static stringcalculator.StringUtils.split;
import static stringcalculator.Validator.validateExpression;

public class Calculator {

  public int calculate(String expression) {
    validateExpression(expression);

    String[] tokens = split(expression);
    Operator operator = Operator.operatorOf(tokens[1]);

    int x = Integer.parseInt(tokens[0]);
    int y = Integer.parseInt(tokens[2]);
    return operator.operate(x, y);
  }
}
