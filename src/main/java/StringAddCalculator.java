import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

  private static final String DEFAULT_DELIMITER = ",|:";
  private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

  public static Integer splitAndSum(String text) {
    if (isBlank(text)) {
      return 0;
    }

    Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);

    if (m.find()) {
      String customDelimiter = m.group(1);
      return sum(toIntegers(Arrays.asList(m.group(2).split(customDelimiter))));
    }

    return sum(toIntegers(defaultSplit(text)));
  }

  private static boolean isBlank(String text) {
    return text == null || text.isBlank();
  }

  private static List<String> defaultSplit(String text) {
    return Arrays.asList(text.split(DEFAULT_DELIMITER));
  }

  private static List<Integer> toIntegers(List<String> values) {
    return values.stream()
        .map(StringAddCalculator::toInteger)
        .collect(Collectors.toList());
  }

  private static Integer sum(List<Integer> numbers) {
    Integer sum = 0;
    for (Integer number : numbers) {
      sum += number;
    }

    return sum;
  }

  private static Integer toInteger(String value) {
    int number = Integer.parseInt(value);
    if (number < 0) {
      throw new RuntimeException("음수는 허용되지 않습니다.");
    }
    return number;
  }
}
