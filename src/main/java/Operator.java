import java.util.function.BiFunction;

public enum Operator {
  PLUS("+", (num1, num2) -> num1 + num2),
  MINUS("-", (num1, num2) -> num1 - num2),
  MULTIPLY("*", (num1, num2) -> num1 * num2),
  DIVIDE("/", Operator::divide);

  private String symbol;
  private BiFunction<Integer, Integer, Integer> expression;

  Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
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

  private static Integer divide(Integer num1, Integer num2) {
    if (num2 == 0) {
      throw new IllegalArgumentException("0으로 나눌수 없습니다.");
    }
    return num1 / num2;
  }

  public int calculate(int num1, int num2) {
    return expression.apply(num1, num2);
  }
}