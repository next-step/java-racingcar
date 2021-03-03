package calculator;

public class StringExpression {

  private String totalExpression;

  public StringExpression(String totalExpression) {
    ExpressionValidator.validate(totalExpression);
    this.totalExpression = totalExpression;
  }

  private class ThreeExpression {

    private final int leftOperand;
    private Operator operator;

    public ThreeExpression(int leftOperand) {
      this.leftOperand = leftOperand;
    }

    public void setOperator(Operator operator) {
      this.operator = operator;
    }

    public ThreeExpression calculate(int rightOperand) {
      if(operator == null) {
        throw new IllegalArgumentException("연산자가 없습니다.");
      }
      return new ThreeExpression(this.operator.calculate(leftOperand, rightOperand));
    }

    public int getResultValue() {
      return this.leftOperand;
    }

  }

  public int calculate() {
    String[] expressionsElement = this.totalExpression.split(" ");
    int firstLeftOperand = Integer.parseInt(expressionsElement[0]);
    ThreeExpression expression = new ThreeExpression(firstLeftOperand);

    for (int i = 1; i < expressionsElement.length; i += 2) {
      String operator = expressionsElement[i];
      int rightValue = Integer.parseInt(expressionsElement[i + 1]);
      expression.setOperator(Operator.get(operator));
      expression = expression.calculate(rightValue);
    }

    return expression.getResultValue();

  }

}
