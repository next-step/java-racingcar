public class Calculator {


  public static String calculate(String input) {
    String[] s = input.split(" ");
    if (s.length % 2 == 0) {
      throw new IllegalArgumentException("입력 값이 null 일 경우");
    }
    CalculatorInputList calculatorInputList = new CalculatorInputList(s);
    CalculatorNumber calculate = calculateRecursive(calculatorInputList);
    return calculate.toString();
  }

  private static CalculatorNumber calculateRecursive(CalculatorInputList s) {
    return calculateRecursive(s, s.getSize());
  }

  private static CalculatorNumber calculateRecursive(CalculatorInputList s, CalculatorNumber i) {
    Operator operator = getOperator(
        s.getElementByIndex(Operator.MINUS.calculate(i, new CalculatorNumber(2))));
    CalculatorNumber first = getFirstNumber(s, i);
    CalculatorNumber second = new CalculatorNumber(
        s.getElementByIndex(Operator.MINUS.calculate(i, new CalculatorNumber(1))));
    return calculate(first, second, operator);
  }

  private static Operator getOperator(CalculatorInput operator) {
    return Operator.of(operator);
  }

  private static CalculatorNumber getFirstNumber(CalculatorInputList s, CalculatorNumber i) {
    CalculatorNumber first;
    if (i.compare(new CalculatorNumber(3))) {
      first = calculateRecursive(s, Operator.MINUS.calculate(i, new CalculatorNumber(2)));
    } else {
      first = new CalculatorNumber(
          s.getElementByIndex(Operator.MINUS.calculate(i, new CalculatorNumber(3))));
    }
    return first;
  }

  private static CalculatorNumber calculate(CalculatorNumber first, CalculatorNumber second,
      Operator operator) {
    return first.operate(second, operator);
  }
}
