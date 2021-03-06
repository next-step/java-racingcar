package study.step2;

import java.util.function.BinaryOperator;

public enum Arithmetic {
  PLUS("+", (firstNumber, secondNumber) -> firstNumber + secondNumber),
  MINUS("-", (firstNumber, secondNumber) -> firstNumber - secondNumber),
  MULTIPLICATION("*", (firstNumber, secondNumber) -> firstNumber * secondNumber),
  DIVISION("/", (firstNumber, secondNumber) -> firstNumber / secondNumber);

  private String code;

  private BinaryOperator<Integer> expression;

  Arithmetic(String code, BinaryOperator<Integer> expression) {
    this.code = code;
    this.expression = expression;
  }

  public int calculate(int firstNumber, int secondNumber) {
    return this.expression.apply(firstNumber, secondNumber);
  }

  public static Arithmetic findByCode(String code) {
    for (Arithmetic value : Arithmetic.values()) {
      if (value.code.equals(code)) {
        return value;
      }
    }
    throw new IllegalArgumentException("Code is not Arithmetic code.");
  }
}
