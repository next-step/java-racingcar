package stringcalculator;

public class Calculator {

  public int calculate(String expression) {
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
}
