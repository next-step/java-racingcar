package study.collection;

import java.util.Arrays;
import study.utils.CheckUtils;

public class InputNumberArr {

  int[] numbers;

  public InputNumberArr(String[] expressionSplit) {
    this.numbers = numberFilter(expressionSplit);
  }

  public int get(int index) {
    return this.numbers[index];
  }

  public int size() {
    return numbers.length;
  }

  private int[] numberFilter(String[] expressionSplit) {
    return Arrays.stream(expressionSplit)
        .filter(CheckUtils::isNumber)
        .mapToInt(Integer::parseInt)
        .toArray();
  }
}
