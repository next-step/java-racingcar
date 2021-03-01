package stringcalculator;

import static stringcalculator.StringUtils.isBlankString;
import static stringcalculator.StringUtils.split;

public class Calculator {

  public int calculate(String expression) {
    if (isBlankString(expression)) {
      throw new IllegalArgumentException("식을 입력해주세요.");
    }

    String[] tokens = split(expression);
    String operator = tokens[1];
    int x = Integer.parseInt(tokens[0]);
    int y = Integer.parseInt(tokens[2]);

    if ("+".equals(operator)) {
      return x + y;
    }
    if ("*".equals(operator)) {
      return x * y;
    }
    if ("/".equals(operator)) {
      return x / y;
    }
    if ("-".equals(operator)) {
      return x - y;
    }

    throw new IllegalArgumentException("해당 연산자는 지원하지 않습니다.");
  }
}
