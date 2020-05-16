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

  private Integer execute(String[] values) {
    int result = 0;
    int increaseForOperatorIndex = 1;
    int increaseForSecondNumberIndex = 2;

    for (int firstNumberIndex = 0; firstNumberIndex < values.length; firstNumberIndex = firstNumberIndex + 3) {
      result = Integer.parseInt(values[firstNumberIndex]);
      String nowOperator = values[firstNumberIndex + increaseForOperatorIndex];
      String nextValue = values[firstNumberIndex + increaseForSecondNumberIndex];
      Operator nowOperatorType = Operator.findOperatorTypeByGivenOperator(nowOperator);
      result = nowOperatorType.calculate(result, Integer.parseInt(nextValue));
    }

    return result;
  }

}
