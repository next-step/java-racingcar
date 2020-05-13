package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
  PLUS('+', (x, y) -> x + y),
  SUBTRACT('-', (x, y) -> x - y),
  MULTIPLY('*', (x, y) -> x * y),
  DIVISION('/', (x, y) -> x / y);

  private final char operator;
  private final BiFunction<Integer, Integer, Integer> operation;

  Operation (final char operator, final BiFunction<Integer, Integer, Integer> operation) {
    this.operator = operator;
    this.operation = operation;
  }

  public static int execute (char operator, int x, int y) {
    return Arrays.stream(Operation.values())
            .filter(v -> v.operator == operator)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(CalculatorError.INVALID_OPERATOR))
            .operation.apply(x, y);
  }
}
