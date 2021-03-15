package study.step2;

public class Operands {

  private final double result;
  private final double number;

  public Operands(double result, String number) {
    Utils.isEmptyOrNull(number);

    this.result = result;
    this.number = Double.parseDouble(number);
  }

  public double getResult() {
    return result;
  }

  public double getNumber() {
    return number;
  }

}
