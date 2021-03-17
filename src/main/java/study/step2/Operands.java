package study.step2;

import org.apache.commons.lang3.StringUtils;

public class Operands {

  private final double result;
  private final double number;

  public Operands(double result, String number) {
    if (StringUtils.isEmpty(number)) {
      throw new IllegalArgumentException();
    }

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
