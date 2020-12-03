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

  private final String operator;
  private final BiFunction<Integer, Integer, Integer> expression;

  CalculateOperator(String operator, BiFunction<Integer, Integer, Integer> expression) {
    this.operator = operator;
    this.expression = expression;
  }

  public int calculate(int x, int y) {
    return this.expression.apply(x, y);
  }

  public static CalculateOperator valueOfOperator(String operator) {
    return Arrays.stream(values())
        .filter(o -> o.operator.equals(operator))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }

}
