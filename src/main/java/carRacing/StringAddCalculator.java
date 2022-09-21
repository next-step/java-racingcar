package carRacing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  public static int splitAndSum(String input) {

    //최종 계산 값
    int answer = 0;

    if (input == null || input.isEmpty()) {
      return 0;
    }

    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

    if (m.find()) {

      String customDelimiter = m.group(1);
      String[] tokens = m.group(2).split(customDelimiter);

      return calculate(tokens, answer);

    }
    String[] tokens = input.split(",|:");
    return calculate(tokens, answer);

  }

  public static int calculate(String[] tokens, int answer) {

    for (String token : tokens) {
      int num = Integer.parseInt(token);

      if (num < 0){
        throw new RuntimeException();
      }
      answer += num;
    }

    return answer;

  }
}



