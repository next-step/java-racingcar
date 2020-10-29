package study;

import static study.exception.ExceptionMessage.INPUT_VALUE_IS_NULL_OR_EMPTY;
import static study.exception.ExceptionMessage.NONE_VALID_INPUT_VALUE;
import static study.utils.CheckUtils.isNotNumber;
import static study.utils.CheckUtils.isNumber;

import study.collection.InputNumberArr;
import study.collection.InputOperatorArr;

public class InputExpressionParser {

  public static String WITHE_SPACE = " ";

  private String expression;
  private InputNumberArr inputNumberArr;
  private InputOperatorArr inputOperatorArr;

  public InputExpressionParser(String expression) {
    this.expression = expression;

    String[] expressionSplit = spaceSplit();
    this.inputNumberArr = new InputNumberArr(expressionSplit);
    this.inputOperatorArr = new InputOperatorArr(expressionSplit);
    validateNumberOperatorCount();
  }

  public InputNumberArr getInputNumberArr() {
    return inputNumberArr;
  }

  public InputOperatorArr getInputOperatorArr() {
    return inputOperatorArr;
  }

  private String[] spaceSplit() {
    validateBefore(expression);
    String[] split = this.expression.split(WITHE_SPACE);
    validateAfter(split);
    return split;
  }

  private void validateBefore(String expression) {
    if (expression == null || expression.equals(WITHE_SPACE)) {
      throw new IllegalArgumentException(INPUT_VALUE_IS_NULL_OR_EMPTY);
    }
  }

  private void validateAfter(String[] split) {
    validateStartNumber(split);
    validateExpressionPosition(split);
  }

  private void validateStartNumber(String[] split) {
    if (isNotNumber(split[0])) {
      throw new IllegalArgumentException(NONE_VALID_INPUT_VALUE);
    }
  }

  private void validateExpressionPosition(String[] split) {
    for (int i = 0; i < split.length - 1; i++) {
      if (isNumber(split[i]) && isNumber(split[i + 1])) {
        throw new IllegalArgumentException(NONE_VALID_INPUT_VALUE);
      }
    }
  }

  private void validateNumberOperatorCount() {
    if (inputNumberArr.size() != inputOperatorArr.size() + 1) {
      throw new IllegalArgumentException(NONE_VALID_INPUT_VALUE);
    }
  }
}
