public class Calculator {

  final static private CalculatorNumber ONE = new CalculatorNumber(1);
  final static private CalculatorNumber TWO = new CalculatorNumber(2);
  final static private CalculatorNumber THREE = new CalculatorNumber(3);
  final static private String SPLIT_CHARACTER = " ";

  public String calculate(String input) {
    String[] splitInput = input.split(SPLIT_CHARACTER);
    if (new CalculatorNumber(splitInput.length).isEven()) {
      throw new IllegalArgumentException("입력 값이 null 일 경우");
    }
    CalculatorInputList calculatorInputList = new CalculatorInputList(splitInput);
    CalculatorNumber calculate = calculateRecursive(calculatorInputList);
    return calculate.toString();
  }

  private CalculatorNumber calculateRecursive(CalculatorInputList calculatorInputList) {
    return calculateRecursive(calculatorInputList, calculatorInputList.getSize());
  }

  private CalculatorNumber calculateRecursive(CalculatorInputList calculatorInputList,
      CalculatorNumber cursor) {
    Operator operator = getOperator(
        calculatorInputList
            .getElementByIndex(Operator.MINUS.calculate(cursor, TWO)));
    CalculatorNumber first = getFirstNumber(calculatorInputList, cursor);
    CalculatorNumber second = new CalculatorNumber(
        calculatorInputList
            .getElementByIndex(Operator.MINUS.calculate(cursor, ONE)));
    return calculate(first, second, operator);
  }

  private Operator getOperator(CalculatorInput operator) {
    return Operator.of(operator);
  }

  private CalculatorNumber getFirstNumber(CalculatorInputList calculatorInputList,
      CalculatorNumber cursor) {
    if (cursor.compare(THREE)) {
      return calculateRecursive(calculatorInputList, Operator.MINUS.calculate(cursor, TWO));
    }
    return new CalculatorNumber(
        calculatorInputList.getElementByIndex(Operator.MINUS.calculate(cursor, THREE)));

  }

  private CalculatorNumber calculate(CalculatorNumber first, CalculatorNumber second,
      Operator operator) {
    return first.operate(second, operator);
  }
}
