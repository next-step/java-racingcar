package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
  SUM("+", (first, second) -> first.sum(second)),
  SUB("-", (first, second) -> first.sub(second)),
  MULTIPLY("*", (first, second) -> first.multiply(second)),
  DIVIDE("/", (first, second) -> first.divide(second));

  private String operator;
  private BiFunction<NumberWrapper, NumberWrapper, NumberWrapper> operation;

  Operator(String operator, BiFunction<NumberWrapper, NumberWrapper, NumberWrapper> operation) {
      this.operator = operator;
      this.operation = operation;
  }

  public NumberWrapper calculate(NumberWrapper first, NumberWrapper second) {
    return operation.apply(first, second);
  }

  public static Operator of(String operator) {
    return Arrays.stream(Operator.values())
                 .filter(op -> op.operator.equals(operator))
                 .findAny()
                 .orElseThrow(IllegalArgumentException::new);
  }


}
