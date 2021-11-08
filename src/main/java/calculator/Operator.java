package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
  PLUS("+", (x, y) -> x + y),
  MINUS("-", (x, y) -> x - y),
  MULTIPLY("*", (x, y) -> x * y),
  DIVIDE("/", (x, y) -> x / y);

  private String operator;

  private BiFunction<Integer, Integer, Integer> expression;

  Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
    this.operator = operator;
    this.expression = expression;
  }

  public static int calculate(String operator, Number number) {
    return Operator.of(operator)
        .expression.apply(number.getFirstOperand(), number.getSecondOperand());
  }

  public static Operator of(String operator) {
    return Arrays.stream(values())
        .filter(o -> o.operator.equals(operator))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}
