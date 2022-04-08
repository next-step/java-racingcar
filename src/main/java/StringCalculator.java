import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

  private final static int NULL_BLANK_RESULT = 0;
  private final static String CUSTOM_DELIMITER = "//(.*)\\n(.*)";
  private final static String DEFAULT_DELIMITER = "[,:]";
  private final static int DELIMITER_GROUP = 1;
  private final static int SPLIT_GROUP = 2;

  private final static Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER);



  public int calculate(String stringNumber) {
    if (stringNumber == null || stringNumber.isBlank()) {
      return NULL_BLANK_RESULT;
    }
    Matcher matcher = PATTERN.matcher(stringNumber);
    if (matcher.find()) {
      String customDelimiter = matcher.group(DELIMITER_GROUP);

      return sum(getIntegerTokens(matcher.group(SPLIT_GROUP)
          .split(customDelimiter)));
    }

    return sum(getIntegerTokens(stringNumber.split(DEFAULT_DELIMITER)));
  }

  public List<Integer> getIntegerTokens(String[] tokens) {
    List<Integer> result = Arrays.stream(tokens).map(Integer::parseInt)
        .collect(Collectors.toList());
    findNegativeNumber(result);
    return result;
  }

  private void findNegativeNumber(List<Integer> input) {
    if (input.stream().anyMatch(num -> num < 0)) {
      throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
    }
  }

  public int sum(List<Integer> numbers) {
    return numbers.stream().reduce(Integer::sum).get();
  }


}
