package calculator;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

enum OperatorType {

  ADD("+", (value1, value2) -> value1 + value2),
  SUBTRACT("-", (value1, value2) -> value1 - value2),
  MULTIPLY("*", (value1, value2) -> value1 * value2),
  DIVISION("/", (value1, value2) -> Math.round(value1 / value2));

  private String symbol;
  private BinaryOperator expression;

  OperatorType(String symbol, BinaryOperator<Integer> expression) {
    this.symbol = symbol;
    this.expression = expression;
  }


  private static OperatorType getOperator(String symbol) {
    return findOperator(symbol).orElseThrow(NoSuchElementException::new);
  }

  public static int calculate(String symbol, int value1, int value2) {
    return (int) getOperator(symbol).expression.apply(value1, value2);
  }

  public static boolean isOperator(String symbol) {
    return findOperator(symbol).isPresent();
  }

  private static Optional<OperatorType> findOperator(String symbol) {
    OperatorType[] values = OperatorType.values();
    return Stream.of(values)
        .filter(operator -> operator.symbol.equals(symbol))
        .findAny();
  }

}
