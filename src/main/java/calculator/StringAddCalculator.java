package calculator;

import calculator.util.SplitUtil;
import calculator.util.StringUtil;

import java.util.List;

public class StringAddCalculator {
  private static final int DEFAULT_VALUE = 0;

  public static int calculate(String input) {
    if (StringUtil.isNullOrEmpty(input)) {
      return DEFAULT_VALUE;
    }
    List<String> splittedStringList = SplitUtil.splitStringIntoList(input);
    return StringUtil.addNumbersInArray(splittedStringList);
  }
}
