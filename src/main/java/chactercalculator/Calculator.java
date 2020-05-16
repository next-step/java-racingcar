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
    int result = Integer.parseInt(splitedList[0]);

    for (int index = 1; index < splitedList.length; index = index + 2) {
      String nowOperator = splitedList[index];
      String nextValue = splitedList[index + 1];
      Operator nowOperatorType = Operator.findOperatorTypeByGivenOperator(nowOperator);
      result = nowOperatorType.calculate(result, Integer.parseInt(nextValue));
    }

    return result;
  }

}
