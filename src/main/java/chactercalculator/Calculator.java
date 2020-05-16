package chactercalculator;

public class Calculator {

  public int calculate(String formula) {
    checkValidation(formula);
    String[] valuesAfterSeparation = separateValuesFromFormula(formula);
    return execute(valuesAfterSeparation);
  }

  private void checkValidation(String formula) {
    if (formula.trim().isEmpty()) {
      throw new IllegalArgumentException("this is wrong.");
    }
  }

  private String[] separateValuesFromFormula(String formula) {
    final String SEPARATOR = " ";
    return formula.split(SEPARATOR);
  }

  private Integer execute(String[] splitedList) {
    int firstNumberIndex = 0;
    int operatorIndex = 1;
    int turnIndex = 2;
    int increaseIndexForNumber = 1;
    int result = Integer.parseInt(splitedList[firstNumberIndex]);

    for (; operatorIndex < splitedList.length; operatorIndex = operatorIndex + turnIndex) {
      String nowOperator = splitedList[operatorIndex];
      String nextValue = splitedList[operatorIndex + increaseIndexForNumber];
      Operator nowOperatorType = Operator.findOperatorTypeByGivenOperator(nowOperator);
      result = nowOperatorType.calculate(result, Integer.parseInt(nextValue));
    }

    return result;
  }

}
