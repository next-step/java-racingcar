package caculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import util.PositiveNumber;

public class Calculator {

  public int calculate(String text) {
    if (isBlank(text)) {
      return  0;
    }

    return sum(toInts(split(text)));
  }

  private boolean isBlank(String text) {
    return text == null || text.isBlank();
  }

  private String[] split(String text) {
    if (text.startsWith("//")) {
      String delimiter = text.substring(2, 3);
      return customSplit(text.substring(4), delimiter);
    }
    return text.split(",|:");
  }

  private String[] customSplit(String text, String delimiter) {
    return text.split(delimiter);
  }

  private int sum(List<Integer> values) {
    return values.stream()
        .map(PositiveNumber::fromInt)
        .mapToInt(PositiveNumber::getValue)
        .sum();
  }

  private List<Integer> toInts(String[] values) {
    return Arrays.stream(values)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}
