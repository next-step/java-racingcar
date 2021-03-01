package stringcalculator;

public class Calculator {

  public int calculate(String expression) {
    if (isBlankString(expression)) {
      throw new IllegalArgumentException("식을 입력해주세요.");
    }

    String[] tokens = expression.split(" ");
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

    return x - y;
  }

  private boolean isBlankString(String string) {
    return string == null || string.trim().isEmpty();
  }
}
