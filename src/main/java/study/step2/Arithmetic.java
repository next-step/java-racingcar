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

  public static Arithmetic findByCode(String code) {
    Arithmetic arithmetic = null;
    for (Arithmetic value : Arithmetic.values()) {
      arithmetic = filterArithmetic(arithmetic, value, code);
    }
    checkArithmetic(arithmetic);
    return arithmetic;
  }

  private static Arithmetic filterArithmetic(Arithmetic arithmetic, Arithmetic value, String code) {
    if (value.code.equals(code)) {
      arithmetic = value;
    }
    return arithmetic;
  }

  private static void checkArithmetic(Arithmetic arithmetic) {
    if (arithmetic == null) {
      throw new IllegalArgumentException("Code is not Arithmetic code.");
    }
  }

  public int calculate(int firstNumber, int secondNumber) {
    return expression.apply(firstNumber, secondNumber);
  }
}
