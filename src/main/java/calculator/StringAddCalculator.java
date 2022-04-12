package calculator;

public class StringAddCalculator {

  private static final int MIN_VALUE = 0;

  private StringAddCalculator() {
  }

  public static int splitAndSum(String expression) {
    if (isBlank(expression)) {
      return MIN_VALUE;
    }
    return calculate(StringParser.split(expression));
  }

  private static boolean isBlank(String expression) {
    return expression == null || expression.isBlank();
  }

  private static int calculate(String[] tokens) {
    int result = 0;
    for (String token : tokens) {
      PositiveNumber number = new PositiveNumber(token);
      result = number.add(result);
    }
    return result;
  }
}
