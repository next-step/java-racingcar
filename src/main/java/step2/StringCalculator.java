package step2;

public class StringCalculator {

  public int operation(String input) {
    checkNotBlankString(input);

    final String[] INPUT_VALUES = StringUtils.split(input, " ");
    
    int result = toInt(INPUT_VALUES[0]);
    for (int i = 0; i < INPUT_VALUES.length - 2; i += 2) {
      String symbol = INPUT_VALUES[i + 1];
      int number = toInt(INPUT_VALUES[i + 2]);
      result = calculation(symbol, result, number);
    }
    return result;
  }

  private void checkNotBlankString(String input) {
    if (StringUtils.isBlank(input))
      throw new IllegalArgumentException();
  }

  private int toInt(String str) {
    return Integer.parseInt(str);
  }

  private int calculation(String symbol, int number1, int number2) {
    return Operation.of(symbol)
            .calculation(number1, number2);
  }

}
