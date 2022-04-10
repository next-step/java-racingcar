import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringNumbers {

  private static final String DEFAULT_DELIMITER = ",|:";
  private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

  private final List<StringOfNumber> stringNumbers;

  private StringNumbers(List<StringOfNumber> stringNumbers) {
    this.stringNumbers = stringNumbers;
  }

  public int sum() {
    int sum = 0;
    for (StringOfNumber stringOfNumber : stringNumbers) {
      sum += stringOfNumber.toInt();
    }
    return sum;
  }

  public static StringNumbers from(String text) {
    return new StringNumbers(split(text).stream()
        .map(StringOfNumber::valueOf)
        .collect(Collectors.toList())
    );
  }

  private static List<String> split(String text) {
    Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);

    if (m.find()) {
      String customDelimiter = m.group(1);
      return Arrays.asList(m.group(2).split(customDelimiter));
    }

    return Arrays.asList(text.split(DEFAULT_DELIMITER));
  }
}
