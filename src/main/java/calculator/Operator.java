package calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

public enum Operator {
  ADD("+", MyNumber::add),
  SUBTRACT("-", MyNumber::subtract),
  MULTIPLY("*", MyNumber::multiply),
  DIVIDE("/", MyNumber::divideBy);

  private final String operator;
  private final BiFunction<MyNumber, MyNumber, MyNumber> operation;

  Operator(String operator, BiFunction<MyNumber, MyNumber, MyNumber> operation) {
    this.operator = operator;
    this.operation = operation;
  }

  public MyNumber operate(MyNumber source, MyNumber target) {
    return operation.apply(source, target);
  }

  public static Operator of(String operator) {
    return Arrays.stream(values())
        .filter(e -> Objects.equals(e.operator, operator))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}
