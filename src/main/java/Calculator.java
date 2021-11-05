public class Calculator {


  public static String calculate(String input) {
    String[] s = input.split(" ");
    int first = Integer.parseInt(s[0]);
    int second = Integer.parseInt(s[2]);
    String operator = s[1];

    return calculate(first, second, operator);
  }

  private static String calculate(int first, int second, String operator) {
    if (operator.equals("+")) {
      return Integer.toString(first + second);
    }
    if (operator.equals("-")) {
      return Integer.toString(first - second);
    }
    if (operator.equals("*")) {
      return Integer.toString(first * second);
    }
    if (operator.equals("/")) {
      if (second == 0) {
        throw new IllegalArgumentException("0으로 나눌수 없습니다.");
      }
      return Integer.toString(first / second);
    }
    throw new IllegalArgumentException("허용되지 않는 연산자입니다.");
  }
}
