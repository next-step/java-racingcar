package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionCalculator {

  private static final String DEFAULT_DELIMITER = ",|:";

  private final String[] input;

  public StringAdditionCalculator(final String input) {
    this.input = parseInput(input);
  }

  public Integer sum() {
    return Arrays.stream(input)
        .map(this::parsePositiveInteger)
        .reduce(0, Integer::sum);
  }

  private String[] parseInput(String input) {
    if (input == null || input.isEmpty()) {
      return new String[]{};
    }

    Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(input);

    String delimiter = DEFAULT_DELIMITER;
    if(matcher.find()) {
      delimiter += "|" + matcher.group(1);
      input = matcher.group(2);
    }

    return input.split(delimiter);
  }

  private Integer parsePositiveInteger(String input) {
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
