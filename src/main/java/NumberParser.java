import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberParser {

  public static List<Integer> parseOnlyPositive(String[] sources) {
    return Arrays.stream(sources)
        .map(NumberParser::onlyPositive)
        .collect(Collectors.toList());
  }

  private static Integer onlyPositive(String source) {
    Integer number = Integer.parseInt(source);
    if (number < 0) {
      throw new RuntimeException("only positive available");
    }
    return number;
  }
}
