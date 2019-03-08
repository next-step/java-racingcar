package calculator;

public class StringCalculator {

  static int calculate(String text) {

    String[] values = text.split(" ");

    int result = Integer.parseInt(values[0]);
    for (int index = 1; index < values.length; index += 2) {
      result = operation(values[index], Integer.parseInt(values[index + 1]), result);
    }
    return result;
  }

  private static int operation(String operator, int value, int result) {

    switch (operator) {
      case "+":
        result += value;
        break;
      case "-":
        result -= value;
        break;
      case "*":
        result *= value;
        break;
      case "/":
        result /= value;
        break;
    }

    return result;
  }
}
