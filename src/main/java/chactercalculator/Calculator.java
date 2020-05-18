package chactercalculator;

import org.apache.commons.lang3.StringUtils;

public class Calculator {

  public int calculate(String formula) {
    checkValidation(formula);
    String[] valuesAfterSeparation = StringTrimmer.separateValuesFromFormula(formula);
    return execute(valuesAfterSeparation);
  }

  private void checkValidation(String formula) {
    if (StringUtils.isBlank(formula)) {
      throw new IllegalArgumentException("this is wrong.");
    }
  }

  private Integer execute(String[] splitedList) {
    int firstNumberIndex = 0;
    int turnIndex = 2;
    int increaseIndexForNumber = 1;
    int result = Integer.parseInt(splitedList[firstNumberIndex]);

    for (int operatorIndex = 1; operatorIndex < splitedList.length; operatorIndex = operatorIndex + turnIndex) {
      String nowOperator = splitedList[operatorIndex];
      String nextValue = splitedList[operatorIndex + increaseIndexForNumber];
      Operator nowOperatorType = Operator.findOperatorTypeByGivenOperator(nowOperator);
      result = nowOperatorType.calculate(result, Integer.parseInt(nextValue));
    }

    return result;
  }

}
