package study1.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.platform.commons.util.StringUtils;

public class CalculatorService {
  /*
    로직
      - exception 체크 / isEmpty
      - for 문 돌면서 계산
        - exception 체크 / isNumber, isEmpty
      - 
  */

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

  public int calculateAll(List<String> strList) {
    if (strList == null) {
      strList = this.strList;
    }

    if (strList.size() < 3) {
      return Integer.parseInt(strList.get(0));
    }

    List<String> copyedList = new ArrayList<>(strList);
    int a = Integer.parseInt(copyedList.remove(0));
    String mark = copyedList.remove(0);
    int b = Integer.parseInt(copyedList.remove(0));

    int num = CalculatorEnum.fromMark(mark).calculate(a, b);
    copyedList.add(0, Integer.toString(num));

    return calculateAll(copyedList);
  }
}
