import java.util.Objects;

public class CalculatorInput {

  private String value;

  public CalculatorInput(String input) {
    this.value = input;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalculatorInput that = (CalculatorInput) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public String toString() {
    return value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  static public CalculatorNumber parseNumber(CalculatorInput input) {
    return new CalculatorNumber(Double.parseDouble(input.value));
  }

}
