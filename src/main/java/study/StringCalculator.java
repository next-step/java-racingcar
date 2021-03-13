package study;


public class StringCalculator {

  public static double calculate(String inputText) {
    String tokens[] = inputText.trim().split(" ");
    double result = toDouble(tokens[0]);

    for (int i = 1; i < tokens.length; i += 2) {
      String operator = tokens[i];
      double number = toDouble(tokens[i + 1]);
      result = Operation.calculate(operator, result, number);
    }

    return result;
  }

  private static double toDouble(String value) {
    if (value == null || "".equals(value)) {
      throw new IllegalArgumentException();
    }
    return Double.parseDouble(value);
  }

}
