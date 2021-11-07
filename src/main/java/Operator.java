import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
  PLUS(new CalculatorInput("+"), Double::sum),
  MINUS(new CalculatorInput("-"), Operator::minus),
  MULTIPLY(new CalculatorInput("*"), Operator::multiply),
  DIVIDE(new CalculatorInput("/"), Operator::divide);

  private CalculatorInput symbol;
  private BiFunction<Double, Double, Double> expression;

  final static int ZERO = 0;

  Operator(CalculatorInput symbol,
      BiFunction<Double, Double, Double> expression) {
    this.symbol = symbol;
    this.expression = expression;
  }

  public static Operator of(CalculatorInput symbol) {
    return Arrays.stream(Operator.values())
        .filter((i) -> i.symbol.equals(symbol))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException("허용되지 않는 연산자입니다."));
  }


  private static Double divide(Double num1, Double num2) {
    if (new CalculatorNumber(num2).equals(new CalculatorNumber(ZERO))) {
      throw new IllegalArgumentException("0으로 나눌수 없습니다.");
    }
    return num1 / num2;
  }

  private static Double multiply(Double num1, Double num2) {
    return num1 * num2;
  }

  private static Double minus(Double num1, Double num2) {
    return num1 - num2;
  }


  public CalculatorNumber calculate(CalculatorNumber num1, CalculatorNumber num2) {
    return num1.calculate(num2, expression);
  }
}