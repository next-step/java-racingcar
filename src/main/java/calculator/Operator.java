package calculator;

import java.util.Arrays;
import java.util.function.Function;

public enum Operator {
  PLUS("+", x -> x.plus()),
  MINUS("-", x -> x.minus()),
  MULTIPLY("*", x -> x.multiply()),
  DIVIDE("/", x -> x.divide());


  private String operator;
  private Function<Number, Integer> expression;

  Operator(String operator, Function<Number, Integer> expression) {
    this.operator = operator;
    this.expression = expression;
  }

  public static int calculate(String operator, Number number) {
    return Operator.of(operator).expression.apply(number);
  }

  public static Operator of(String operator) {
    return Arrays.stream(values())
        .filter(o -> o.operator.equals(operator))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}
