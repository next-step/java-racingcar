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
    return Arrays.stream(tokens).map(Integer::parseInt).collect(Collectors.toList());
  }

  public int sum(List<Integer> numbers) {
    return numbers.stream().reduce(Integer::sum).get();
  }


}
