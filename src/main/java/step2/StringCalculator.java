package step2;

import racing.utils.StringUtils;

public class StringCalculator {

  public int operation(String input) {
    checkNotBlankString(input);

    final String[] inputValues = StringUtils.split(input, " ");
    
    int result = toInt(inputValues[0]);
    for (int i = 0; i < inputValues.length - 2; i += 2) {
      String symbol = inputValues[i + 1];
      int number = toInt(inputValues[i + 2]);
      result = calculation(symbol, result, number);
    }
    return result;
  }

  private void checkNotBlankString(String input) {
    if (StringUtils.isBlank(input)) {
      throw new IllegalArgumentException("Cannot use 0 or NULL value.");
    }
  }

  private int toInt(String str) {
    return Integer.parseInt(str);
  }

  private int calculation(String symbol, int number1, int number2) {
    return Operation.of(symbol)
            .calculation(number1, number2);
  }

}
