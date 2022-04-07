import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

  private String CUSTOM_DELIMITER = "//(.*)\\n(.*)";
  private String DEFAULT_DELIMITER = "[,:]";

  private int DELIMITER_GROUP = 1;
  private int SPLIT_GROUP = 2;

  public int calculate(String str) {
    if (str == null || str.equals("")) {
      return 0;
    }

    Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(str);
    if (matcher.find()) {
      String customDelimiter = matcher.group(DELIMITER_GROUP);
      return sum(getIntegerTokens(matcher.group(SPLIT_GROUP)
          .split(customDelimiter)));
    }

    return sum(getIntegerTokens(str.split(DEFAULT_DELIMITER)));
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
