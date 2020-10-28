package study.collection;

import java.util.Arrays;
import study.utils.CheckUtils;

public class InputOperatorArr {

  String[] operators;

  public InputOperatorArr(String[] expressionSplit) {
    this.operators = operatorFilter(expressionSplit);
  }

  public String get(int index) {
    return this.operators[index];
  }

  public int size() {
    return operators.length;
  }

  private String[] operatorFilter(String[] expressionSplit) {
    return Arrays.stream(expressionSplit)
        .filter(CheckUtils::isNotNumber)
        .toArray(String[]::new);
  }
}
