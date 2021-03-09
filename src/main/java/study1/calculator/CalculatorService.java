package study1.calculator;

import java.util.Arrays;
import java.util.List;

public class CalculatorService {

  private List<String> letters;

  public CalculatorService(String str) {
    CalculatorValidationEnum.fromIndex(1).check(str);
    this.letters = Arrays.asList(str.split(" "));
    int index = 0;
    for (String s : this.letters) {
      CalculatorValidationEnum.fromIndex(index).check(s);
      index++;
    }
  }

  public int calculateAll() {
    int total = Integer.parseInt(letters.get(0));
    for(int i = 1; i < letters.size(); i += 2) {
      total = CalculatorEnum.fromMark(letters.get(i)).calculate(total, Integer.parseInt(letters.get(i+1)));
    }
    return total;
  }
}
