package stringcalculator;

public class Calculator {

  public int calculate(String expression) {
    String[] tokens = expression.split(" ");

    if ("+".equals(tokens[1])) {
      return Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]);
    }

    return Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[2]);
  }
}
