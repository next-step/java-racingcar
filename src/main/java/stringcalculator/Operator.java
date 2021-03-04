package stringcalculator;

import java.util.function.BinaryOperator;

public enum Operator {

  PLUS("+", (x, y) -> x + y),
  MINUS("-", (x, y) -> x - y),
  MULTIPLY("*", (x, y) -> x * y),
  DIVIDE("/", (x, y) -> x / y);

  private final String value;
  private final BinaryOperator<Integer> operator;

  Operator(String value, BinaryOperator<Integer> operator) {
    this.value = value;
    this.operator = operator;
  }

  public static Operator operatorOf(String operator) {
    if (PLUS.value.equals(operator)) {
      return PLUS;
    }
    if (MINUS.value.equals(operator)) {
      return MINUS;
    }
    if (MULTIPLY.value.equals(operator)) {
      return MULTIPLY;
    }
    if (DIVIDE.value.equals(operator)) {
      return DIVIDE;
    }
    throw new IllegalArgumentException("해당 연산자는 지원하지 않습니다.");
  }

  public int operate(int x, int y) {
    return operator.apply(x, y);
  }
}
