package common;

public class SimpleCalculator {

  private static final String DELIMITER = " ";
  private static final String ADDITION = "+";
  private static final String SUBTRACTION = "-";
  private static final String MULTIPLICATION = "*";
  private static final String DIVISION = "/";

  private String formula;

  public SimpleCalculator(String formula) {
    checkFormulaIsBlank(formula);
    this.formula = formula;
  }

  private void checkFormulaIsBlank(String formula) {
    if (Strings.isBlank(formula)) {
      throw new IllegalArgumentException(String.format("formula is blank. formula : %s", formula));
    }
  }

  public int calculate() {
    String[] elements = formula.split(DELIMITER);
    int result = Integer.parseInt(elements[0]);

    for (int i = 1; i < elements.length; i = i + 2) {
      String operator = elements[i];
      int operand = Integer.parseInt(elements[i + 1]);
      result = calculate(result, operator, operand);
    }

    return result;
  }

  private int calculate(int firstNumber, String operator, int secondNumber) {
    switch (operator) {
      case ADDITION : return firstNumber + secondNumber;
      case SUBTRACTION : return firstNumber - secondNumber;
      case MULTIPLICATION : return firstNumber * secondNumber;
      case DIVISION : return firstNumber / secondNumber;
      default : throw new IllegalArgumentException(String.format("invalid operator. operator : %s", operator));
    }
  }

}