package calculator;

import java.util.Arrays;
import java.util.List;

class Numbers {
  private final List<Integer> values;

  private Numbers(List<Integer> values) {
    this.values = values;
  }

  static Numbers from(String[] tokens){
    List<Integer> numbers = Arrays.stream(tokens)
        .map(Integer::parseInt)
        .toList();
    validatePositive(numbers);
    return new Numbers(numbers);
  }

  private static void validatePositive(List<Integer> numbers) {
    if (numbers.stream().anyMatch(number -> number < 0)) {
      throw new RuntimeException("음수");
    }
  }

  int sum() {
    return values.stream()
        .mapToInt(Integer::intValue)
        .sum();
  }
}
