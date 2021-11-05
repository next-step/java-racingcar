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
      String operator = values[i];
      int second = Integer.parseInt(values[i + 1]);

      Number number = new Number(result, second);
      result = Operator.calculate(operator, number);
    }

    return result;
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
