import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberParser {

  public static boolean isNumber(String source) {
    try {
      Integer.parseInt(source);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  public static List<Integer> parse(String[] sources) {
    return Arrays.stream(sources)
        .map((token -> Integer.parseInt(token)))
        .collect(Collectors.toList());
  }
}
