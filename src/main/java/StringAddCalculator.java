import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

  public static int splitAndSum(String text) {
    if (text == null || text.isEmpty()) {
      return 0;
    }

    if (text.startsWith("//")) {
      Matcher m = pattern.matcher(text);
      if (m.find()) {
        String customDelimiter = m.group(1);
        String values = m.group(2);
        return sum(values.split(customDelimiter));
      }
    }

    return sum(text.split("[,:]"));
  }

  private static int sum(String[] values) {
    int result = 0;
    for (String value : values) {
      result += validateAndTransform(value);
    }
    return result;
  }

  private static Integer validateAndTransform(String value) throws RuntimeException {
    if (!Character.isDigit(value.charAt(0))) {
      throw new RuntimeException();
    }
    return Integer.parseInt(value);
  }
}
