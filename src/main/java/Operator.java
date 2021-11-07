import java.util.function.BiFunction;

public enum Operator {
  PLUS(new CalculatorInput("+"), Double::sum),
  MINUS(new CalculatorInput("-"), (num1, num2) -> num1 - num2),
  MULTIPLY(new CalculatorInput("*"), (num1, num2) -> num1 * num2),
  DIVIDE(new CalculatorInput("/"), Operator::divide);

  private CalculatorInput symbol;
  private BiFunction<Double, Double, Double> expression;

  Operator(CalculatorInput symbol,
      BiFunction<Double, Double, Double> expression) {
    this.symbol = symbol;
    this.expression = expression;
  }

  public static Operator of(CalculatorInput symbol) {
    for (Operator operator : Operator.values()) {
      if (operator.symbol.equals(symbol)) {
        return operator;
      }
    }
    throw new IllegalArgumentException("허용되지 않는 연산자입니다.");
  }


  private static Double divide(Double num1, Double num2) {
    if (new CalculatorNumber(num2).equals(new CalculatorNumber(0))) {
      throw new IllegalArgumentException("0으로 나눌수 없습니다.");
    }
    return num1 / num2;
  }


  public CalculatorNumber calculate(CalculatorNumber num1, CalculatorNumber num2) {
    return num1.calculate(num2, expression);
  }
}