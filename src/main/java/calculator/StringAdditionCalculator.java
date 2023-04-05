package calculator;

import java.util.Arrays;

public class StringAdditionCalculator {

  public static StringAdditionCalculator getInstance() {
    return StringAdditionCalculatorHolder.INSTANCE;
  }

  private StringAdditionCalculator() {}

  private static class StringAdditionCalculatorHolder {
    private static final StringAdditionCalculator INSTANCE = new StringAdditionCalculator();
  }

  public Integer sum(final AdditionalString input) {
    return Arrays.stream(input.split())
        .map(this::parsePositiveInteger)
        .reduce(0, Integer::sum);
  }

  private Integer parsePositiveInteger(final String input) {
    int number;

    try {
      number = Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new RuntimeException();
    }

    if (number < 0) {
      throw new RuntimeException();
    }

    return number;
  }
}
