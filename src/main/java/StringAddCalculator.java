import java.util.List;

public class StringAddCalculator {

  public static int splitAndSum(String source) {
    if (isBlank(source)) {
      return 0;
    }

    if (NumberParser.isNumber(source)) {
      return Integer.parseInt(source);
    }

    String[] tokens = Tokenizer.tokenize(source);
    return sum(NumberParser.parse(tokens));
  }

  private static boolean isBlank(String source) {
    return source == null || source.isEmpty();
  }

  private static int sum(List<Integer> numbers) {
    return numbers.stream().reduce((x, y) -> x + y).orElse(0);
  }
}
