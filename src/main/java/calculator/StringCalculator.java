package calculator;

import java.util.regex.Pattern;

public class StringCalculator {

  private static final String DELIMITER = " ";
  private static final String INPUT_PATTERN = "^(\\d+ [-+*/] )+\\d+$";

  public static int calculate(String input) {
    validate(input);

    String[] values = input.split(DELIMITER);
    int result = Integer.parseInt(values[0]);

    for (int i = 1; i < values.length; i += 2) {
      result = calculate(result, values[i], Integer.parseInt(values[i + 1]));
    }

    return result;
  }

  private static int calculate(int firstOperand, String operator, int secondOperand) {
    Number number = new Number(firstOperand, secondOperand);
    return Operator.calculate(operator, number);
  }

  private static void validate(String input) {
    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException("Cannot null or empty");
    }

    if (!Pattern.matches(INPUT_PATTERN, input)) {
      throw new IllegalArgumentException("Pattern is invalid");
    }

  }
}
