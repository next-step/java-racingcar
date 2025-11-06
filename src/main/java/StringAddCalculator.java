import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  private static String delimiter = ":|,";
  public static int splitAndSum(String input) {
    if(input == null || input.isBlank()) {
      return 0;
    }

    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
    if (m.find()) {
      delimiter = m.group(1);
      input = m.group(2);
    }

    String[] tokens = input.split(delimiter);
    List<Integer> numbers = Arrays.stream(tokens)
        .map(Integer::parseInt)
        .toList();

    int result = 0;
    for(int number : numbers){
      if(number < 0) throw new RuntimeException("음수");
      result += number;
    }
    return result;
  }
}
