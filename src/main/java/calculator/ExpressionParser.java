package calculator;

public class ExpressionParser {

  private static final String SEPARATOR = " ";

  public static Expression parse(String expression) {
    return separateNumberAndOperator(separateStringExpression(expression));
  }

  private static Expression separateNumberAndOperator(String[] separatedExpression) {
    return new Expression(new Numbers(separatedExpression), new Operator(separatedExpression));
  }

  public static String[] separateStringExpression(String expression) {
    return expression.split(SEPARATOR);
  }

}
