package study1.calculator;

import java.util.Arrays;

public enum CalculatorEnum {
  ADD("+", (a, b) -> a + b),
  SUBSTRACT("-", (a, b) -> a - b),
  MULTIPLY("*", (a, b) -> a * b),
  DIVIDE("/", (a, b) -> a / b);

  private final String mark;
  private final Expression expression;

  interface Expression {
    int calculate(int a, int b);
  }

  CalculatorEnum(String mark, Expression expression) {
    this.mark = mark;
    this.expression = expression;
  }

  public static CalculatorEnum fromMark(String mark) {
    return Arrays
      .stream(CalculatorEnum.values())
      .filter(calculator -> calculator.mark.equals(mark))
      .findAny()
      .orElseThrow(() -> new IllegalArgumentException("not mark error"));
  }

  public int calculate(int a, int b) {
    return this.expression.calculate(a, b);
  }
}
