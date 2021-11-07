import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorInputList {

  private List<CalculatorInput> values;

  public CalculatorInputList(String[] input) {
    this.values = Arrays.stream(input)
        .map(CalculatorInput::new)
        .collect(Collectors.toList());
  }

  public CalculatorNumber getSize() {
    return new CalculatorNumber(this.values.size());
  }

  public CalculatorInput getElementByIndex(CalculatorNumber i) {
    return values.get(CalculatorNumber.parseInt(i));
  }
}
