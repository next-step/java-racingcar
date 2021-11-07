import java.util.Objects;

public class CalculatorNumber {

  private double value;

  public CalculatorNumber(int i) {
    this.value = i;
  }

  public CalculatorNumber(double i) {
    this.value = i;
  }

  public CalculatorNumber(String i) {
    this.value = Double.parseDouble(i);
  }

  public String toString() {
    return Double.toString(this.value).replaceAll("\\.0$", "");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalculatorNumber that = (CalculatorNumber) o;
    return Double.compare(that.value, value) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  public CalculatorNumber operate(CalculatorNumber input, Operator operator) {
    return new CalculatorNumber(operator.calculate(this.value, input.value));
  }
}
