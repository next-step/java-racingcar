public class Calculator {


  public static String calculate(String input) {
    String[] s = input.split(" ");
    if (s.length % 2 == 0) {
      throw new IllegalArgumentException("입력 값이 null 일 경우");
    }

    String calculate = calculateRecursive(s);
    return calculate;
  }

  private static String calculateRecursive(String[] s) {
    return calculateRecursive(s, s.length);
  }

  private static String calculateRecursive(String[] s, int i) {
    int first;
    int second = Integer.parseInt(s[i - 1]);
    String operator = s[i - 2];
    if (i > 3) {
      first = Integer.parseInt(calculateRecursive(s, i - 2));
    } else {
      first = Integer.parseInt(s[i - 3]);
    }
    return calculate(first, second, operator);
  }

  private static String calculate(int first, int second, String operator) {
    return Integer.toString(Operator.of(operator).calculate(first, second));
  }
}
