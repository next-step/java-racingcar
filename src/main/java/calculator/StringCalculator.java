package calculator;

public class StringCalculator implements Calculator {

  @Override
  public int calculate(String expression) {
    ExpressionValidator.validate(expression);
    Expression expr = ExpressionParser.parse(expression);
    return expr.calculate();
  }
}
