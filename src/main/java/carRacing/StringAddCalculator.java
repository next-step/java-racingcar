package carRacing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {


  private static final String DELIMITER_REGEX = "//(.)\n(.*)";
  private static final String DEFAULT_REGEX = ",|:";
  private static final Integer TARGET_DELIMITER = 1;
  private static final Integer TARGET_TOKENS = 2;

  public static int splitAndSum(String input) {

    int answer = 0;

    if (input == null || input.isEmpty()) {
      return 0;
    }

    Matcher m = Pattern.compile(DELIMITER_REGEX).matcher(input);

    if (m.find()) {

      String customDelimiter = m.group(TARGET_DELIMITER);
      String[] tokens = m.group(TARGET_TOKENS).split(customDelimiter);

      return calculate(tokens, answer);

    }
    String[] tokens = input.split(DEFAULT_REGEX);
    return calculate(tokens, answer);

  }

  public static int calculate(String[] tokens, int answer) {

    for (String token : tokens) {
      int num = Integer.parseInt(token);

      if (num < 0) {
        throw new RuntimeException();
      }
      answer += num;
    }

    return answer;

  }
}



