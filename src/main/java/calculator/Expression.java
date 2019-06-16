package calculator;

public class Expression {

  private Numbers numbers;
  private Operator operators;

  public Expression(Numbers numbers, Operator operator) {
    this.numbers = numbers;
    this.operators = operator;
  }


  public int calculate() {

    while (numbers.hasNumber()) {
      int leftValue = numbers.leftValue();
      int rightValue = numbers.rightVale();
      int result = operators.calculate(leftValue, rightValue);
      numbers.changeNumberToResult(result);
    }
    return numbers.getResult();
  }
}
