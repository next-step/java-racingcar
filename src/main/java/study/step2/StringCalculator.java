package study.step2;

public class StringCalculator {
  private Integer firstNumber;
  private Integer secondNumber;
  private Integer result;
  private Arithmetic arithmetic;
  private boolean isNotNull = true;

  public int calculate(String expression) {
    String[] splitExpression = expression.split(" ");
    calculateExpression(splitExpression);
    int result = this.result;
    initialize();
    return result;
  }

  private void calculateExpression(String[] splitExpression) {
    for (String value : splitExpression) {
      assignSecondNumber(value);
      assignArithmetic(value);
      assignFirstNumber(value);
      calculate();
    }
  }

  private void assignSecondNumber(String value) {
    if (this.firstNumber != null && this.arithmetic != null && secondNumber == null) {
      this.secondNumber = parseInt(value);
    }
  }

  private void assignArithmetic(String value) {
    if (this.firstNumber != null && this.arithmetic == null && this.secondNumber == null) {
      this.arithmetic = Arithmetic.findByCode(value);
    }
  }

  private void assignFirstNumber(String value) {
    if (this.firstNumber == null && this.arithmetic == null && this.secondNumber == null) {
      this.firstNumber = parseInt(value);
    }
  }

  public boolean isNotNullValues(Object... values) {
    for (Object value : values) {
      checkNull(value);
    }
    boolean isNotNull = this.isNotNull;
    this.isNotNull = true;

    return isNotNull;
  }


  private void checkNull(Object value) {
    if (value == null) {
      this.isNotNull = false;
    }
  }

  private void calculate() {
    if (this.firstNumber != null && this.arithmetic != null && this.secondNumber != null) {
      this.result = this.arithmetic.calculate(this.firstNumber, this.secondNumber);
      this.firstNumber = this.result;
      this.arithmetic = null;
      this.secondNumber = null;
    }
  }

  private void initialize() {
    this.firstNumber = null;
    this.arithmetic = null;
    this.secondNumber = null;
    this.result = null;
  }

  public int parseInt(String numberString) {
    return Integer.parseInt(numberString);
  }

}
