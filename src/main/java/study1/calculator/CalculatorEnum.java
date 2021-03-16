package study1.calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum CalculatorEnum {
  ADD("+", (number1, number2) -> number1 + number2),
  SUBSTRACT("-", (number1, number2) -> number1 - number2),
  MULTIPLY("*", (number1, number2) -> number1 * number2),
  DIVIDE(
    "/",
    (number1, number2) -> {
      if (number2 == 0) {
        throw new IllegalArgumentException("devide zero error");
      }
      return number1 / number2;
    }
  );

  private final String mark;
  private final BiFunction<Integer, Integer, Integer> expression;

  CalculatorEnum(
    String mark,
    BiFunction<Integer, Integer, Integer> expression
  ) {
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

  public int calculate(int number1, int number2) {
    return this.expression.apply(number1, number2);
  }
}
