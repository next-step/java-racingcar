import java.util.Objects;
import java.util.function.BiFunction;

public class CalculatorNumber {

  private double value;
  private static final String DOUBLE_TO_STRING_REGEX = "\\.0$";

  public CalculatorNumber(int input) {
    this.value = input;
  }

  public CalculatorNumber(double input) {
    this.value = input;
  }

  public CalculatorNumber(CalculatorInput input) {
    this.value = CalculatorInput.parseNumber(input).value;
  }

  public String toString() {
    return Double.toString(this.value).replaceAll(DOUBLE_TO_STRING_REGEX, "");
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

  public boolean compare(CalculatorNumber input) {
    return this.value > input.value;
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

  public static int parseInt(CalculatorNumber input) {
    return (int) input.value;
  }

  public boolean isEven() {
    return (this.value % 2) == 0;
  }
}
