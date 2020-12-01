package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum CalculateOperator {
  PLUS("+", (x, y) -> x + y),
  MINUS("-", (x, y) -> x - y),
  MULTIPLY("*", (x, y) -> x * y),
  DIVIDE("/", (x, y) -> {
    if (y == 0) {
      throw new IllegalArgumentException();
    }
    return x / y;
  });

  private String operator;
  private BiFunction<Integer, Integer, Integer> expression;

  CalculateOperator(String operator, BiFunction<Integer, Integer, Integer> expression) {
    this.operator = operator;
    this.expression = expression;
  }

  public static int calculate(String operator, Integer x, Integer y) {
    return getOperator(operator).expression.apply(x, y);
  }

  private static CalculateOperator getOperator(String operator) {
    return Arrays.stream(values())
        .filter(o -> o.operator.equals(operator))
        .findFirst().orElseThrow(IllegalArgumentException::new);
  }

}
