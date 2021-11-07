public class Calculator {


  public static String calculate(String input) {
    String[] s = input.split(" ");
    if (s.length % 2 == 0) {
      throw new IllegalArgumentException("입력 값이 null 일 경우");
    }

    CalculatorNumber calculate = calculateRecursive(s);
    return calculate.toString();
  }

  private static CalculatorNumber calculateRecursive(String[] s) {
    return calculateRecursive(s, s.length);
  }

  private static CalculatorNumber calculateRecursive(String[] s, int i) {
    CalculatorNumber first;
    CalculatorNumber second = new CalculatorNumber(s[i - 1]);
    String operator = s[i - 2];
    if (i > 3) {
      first = calculateRecursive(s, i - 2);
    } else {
      first = new CalculatorNumber(s[i - 3]);
    }
    return calculate(first, second, operator);
  }

  private static CalculatorNumber calculate(CalculatorNumber first, CalculatorNumber second,
      String operator) {
    return first.operate(second, Operator.of(operator));
  }
}
