package stringcalculator;

import static stringcalculator.StringUtils.isBlankString;
import static stringcalculator.StringUtils.split;

public class Calculator {

  public int calculate(String expression) {
    if (isBlankString(expression)) {
      throw new IllegalArgumentException("식을 입력해주세요.");
    }

    String[] tokens = split(expression);
    Operator operator = Operator.operatorOf(tokens[1]);

    int x = Integer.parseInt(tokens[0]);
    int y = Integer.parseInt(tokens[2]);
    return operator.operate(x, y);
  }
}
