package study.step2;

public class StringCalculator {
  private Integer firstNumber;
  private Integer secondNumber;
  private Arithmetic arithmetic;

  public int calculate(String expression) {
    String[] splitExpression = expression.split(" ");
    int result = calculateExpression(splitExpression);
    initialize();
    return result;
  }

  private int calculateExpression(String[] splitExpression) {
    int result = 0;
    for (String value : splitExpression) {
      assignSecondNumber(value);
      assignArithmetic(value);
      assignFirstNumber(value);
      result = calculate(result);
    }
    return result;
  }

  private void assignSecondNumber(String value) {
    if (this.firstNumber != null && this.arithmetic != null && secondNumber == null) {
      this.secondNumber = parseInt(value);
    }
  }

  public int parseInt(String numberString) {
    return Integer.parseInt(numberString);
  }

  private void assignArithmetic(String value) {
    if (this.firstNumber != null && this.arithmetic == null && this.secondNumber == null) {
      this.arithmetic = Arithmetic.findByCode(value);
    }
  }

  private void assignFirstNumber(String value) {
    if (this.firstNumber == null) {
      this.firstNumber = parseInt(value);
    }
  }

  private int calculate(int result) {
    if (this.firstNumber != null && this.arithmetic != null && this.secondNumber != null) {
      result = this.arithmetic.calculate(this.firstNumber, this.secondNumber);
      this.firstNumber = result;
      this.arithmetic = null;
      this.secondNumber = null;
    }
    return result;
  }

  private void initialize() {
    this.firstNumber = null;
    this.arithmetic = null;
    this.secondNumber = null;
  }

}
