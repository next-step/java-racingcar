import java.util.function.BiFunction;

public enum Operator {
  PLUS("+", Double::sum),
  MINUS("-", (num1, num2) -> num1 - num2),
  MULTIPLY("*", (num1, num2) -> num1 * num2),
  DIVIDE("/", Operator::divide);

  private String symbol;
  private BiFunction<Double, Double, Double> expression;

  Operator(String symbol, BiFunction<Double, Double, Double> expression) {
    this.symbol = symbol;
    this.expression = expression;
  }

  public static Operator of(String symbol) {
    for (Operator operator : Operator.values()) {
      if (operator.symbol.equals(symbol)) {
        return operator;
      }
    }
    throw new IllegalArgumentException("허용되지 않는 연산자입니다.");
  }

  private static double divide(double num1, double num2) {
    if (num2 == 0) {
      throw new IllegalArgumentException("0으로 나눌수 없습니다.");
    }
    return num1 / num2;
  }

  public double calculate(double num1, double num2) {
    return expression.apply(num1, num2);
  }
}