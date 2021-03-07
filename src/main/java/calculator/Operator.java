package calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
  ADD("+", (firstVal, secondVal) -> firstVal + secondVal),
  SUB("-", (firstVal, secondVal) -> firstVal - secondVal),
  MUL("*", (firstVal, secondVal) -> firstVal * secondVal),
  DIV("/", (firstVal, secondVal) -> firstVal / secondVal);

  private String operator;
  private BinaryOperator<Integer> expression;

  Operator(String operator, BinaryOperator<Integer> expression) {
    this.operator = operator;
    this.expression = expression;
  }

  public static Operator getOperator(String operator) {
    return Arrays.stream(values())
        .filter(op -> op.operator.equals(operator))
        .findAny().orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아닙니다."));
  }

  public static int calculate(int firstVal, int secondVal, String operator) {
    return getOperator(operator).expression.apply(firstVal, secondVal);
  }
}
