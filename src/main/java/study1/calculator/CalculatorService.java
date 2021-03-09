package study1.calculator;

import java.util.Arrays;
import java.util.List;

public class CalculatorService {

  private List<String> strList;

  public CalculatorService(String str) {
    CalculatorValidationEnum.fromIndex(1).check(str);
    this.strList = Arrays.asList(str.split(" "));
    int index = 0;
    for (String s : this.strList) {
      CalculatorValidationEnum.fromIndex(index).check(s);
      index++;
    }
  }

  public int calculateAll() {
    int total = Integer.parseInt(strList.get(0));
    for(int i = 1; i < strList.size(); i += 2) {
      total = CalculatorEnum.fromMark(strList.get(i)).calculate(total, Integer.parseInt(strList.get(i+1)));
    }
    return total;
  }
}
