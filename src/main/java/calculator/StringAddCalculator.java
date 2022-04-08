package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringAddCalculator {

  private static final String OR = "|";
  private static final String BASE_SPLIT_REGEX = ",|:";
  private static final String CUSTOM_DELIMITER_FIND_REGEX = "^//(.*)\n(.*)";
  private static final Pattern CUSTTOM_DELIMITER_PATTERN = Pattern.compile(
      CUSTOM_DELIMITER_FIND_REGEX);

  public int calcSum(String text) {
    if (isEmptyOrNull(text)) {
      return 0;
    }

    if (containsCustomDelimiter(text)) {
      return customDelimiterSum(text);
    }

    return normalDelimiterSum(text);
  }

  private boolean isEmptyOrNull(String text) {
    return text == null || text.isEmpty();
  }

  private boolean containsCustomDelimiter(String text) {
    return text.matches(CUSTOM_DELIMITER_FIND_REGEX);
  }

  private int customDelimiterSum(String text) {
    Matcher customDelimiterMatch = CUSTTOM_DELIMITER_PATTERN.matcher(text);
    customDelimiterMatch.find();

    String customDelimiter = customDelimiterMatch.group(1);
    String delimiterRemovedText = customDelimiterMatch.group(2);

    List<Integer> splitted = split(BASE_SPLIT_REGEX + OR + customDelimiter, delimiterRemovedText);
    checkPositive(splitted);
    return sum(splitted);
  }

  private List<Integer> split(String delimiter, String text) {
    try {
      return Stream.of(text.split(delimiter))
          .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    } catch (Exception e) {
      throw new RuntimeException("input text must contains only delimiter or number");
    }
  }

  private void checkPositive(List<Integer> nums) {
    for (Integer num : nums) {
      checkPositive(num);
    }
  }

  private void checkPositive(Integer num) {
    if (num < 0) {
      throw new RuntimeException("number is negative");
    }
  }

  private int sum(List<Integer> splittedNumber) {
    return splittedNumber.stream().mapToInt(i -> i).sum();
  }

  private int normalDelimiterSum(String text) {
    List<Integer> splitted = split(BASE_SPLIT_REGEX, text);
    checkPositive(splitted);
    return sum(splitted);
  }

}
