import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {

  private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");
  private static final String basicDelimiter = "[,:]";

  public static int splitAndSum(String text) {
    if (text == null || text.isEmpty()) {
      return 0;
    }

    Matcher m = pattern.matcher(text);

    return m.find() ? sum(m.group(2).split(m.group(1))) : sum(text.split(basicDelimiter));
  }

  private static int sum(String[] values) {
    return Arrays.stream(values)
        .mapToInt(StringAddCalculator::parseInt)
        .reduce(0, Integer::sum);
  }

  private static Integer parseInt(String value) throws RuntimeException {
    var transformedValue = 0;

    try {
       transformedValue = Integer.parseInt(value);
    } catch (NumberFormatException e) {
      throw new RuntimeException();
    }

    if (transformedValue < 0) {
      throw new RuntimeException();
    }

    return transformedValue;
  }
}
