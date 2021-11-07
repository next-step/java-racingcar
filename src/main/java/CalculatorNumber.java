import java.util.Objects;
import java.util.function.BiFunction;

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

  public CalculatorNumber(CalculatorInput i) {
    this.value = CalculatorInput.parseNumber(i).value;
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

  public boolean compare(CalculatorNumber i) {
    return this.value > i.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  public CalculatorNumber operate(CalculatorNumber input, Operator operator) {
    return operator.calculate(this, input);
  }

  public CalculatorNumber calculate(CalculatorNumber input,
      BiFunction<Double, Double, Double> expression) {
    return new CalculatorNumber(expression.apply(this.value, input.value));
  }

  public static int parseInt(CalculatorNumber i) {
    return (int) i.value;
  }
}
