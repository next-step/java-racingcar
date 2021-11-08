package calculator;

public class Number {

  private int firstOperand;
  private int secondOperand;

  public Number(int firstOperand, int secondOperand) {
    this.firstOperand = firstOperand;
    this.secondOperand = secondOperand;
  }

  public int getFirstOperand() {
    return firstOperand;
  }

  public int getSecondOperand() {
    return secondOperand;
  }

}
