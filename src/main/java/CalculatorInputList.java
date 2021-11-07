import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorInputList {

  private List<CalculatorInput> values = new ArrayList<>();

  public CalculatorInputList(String[] s) {
    this.values = Arrays.stream(s).map(CalculatorInput::new).collect(Collectors.toList());
  }

  public CalculatorNumber getSize() {
    return new CalculatorNumber(this.values.size());
  }

  public CalculatorInput getElementByIndex(CalculatorNumber i) {
    return values.get(CalculatorNumber.parseInt(i));
  }
}
