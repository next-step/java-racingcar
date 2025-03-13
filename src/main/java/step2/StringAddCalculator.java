package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  private static final String DEFAULT_DELIMITER = "[,:]";
  private static final String PATTERN = "//(.)\n(.*)";

  public static int splitAndSum(String formula) {
    if (isEmpty(formula)) {
      return 0;
    }

    String delimiter = getDelimiter(formula);
    String value = getValue(formula);

    String[] tokens = value.split(delimiter);
    checkContainsNegativeNumber(tokens);

    return add(tokens);
  }

  private static boolean isEmpty(String s) {
    return s == null || s.isEmpty();
  }

  private static String getDelimiter(String s) {
    Matcher m = Pattern.compile(PATTERN).matcher(s);
    return m.find() ? m.group(1) : DEFAULT_DELIMITER;
  }

  private static String getValue(String s) {
    Matcher m = Pattern.compile(PATTERN).matcher(s);
    return m.find() ? m.group(2) : s;
  }

  private static void checkContainsNegativeNumber(String[] tokens) {
    for (String token : tokens) {
      if (Integer.parseInt(token) < 0) {
        throw new RuntimeException();
      }
    }
  }

  private static int add(String[] tokens) {
    return Arrays.stream(tokens)
        .mapToInt(Integer::parseInt)
        .sum();
  }
}
