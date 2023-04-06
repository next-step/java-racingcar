package study;

import java.util.Arrays;


public class StringAddCalculator {

  public static int splitAndSum(String text) {
    if (checkEmptyOrNull(text)) {
      return 0;
    }

    return sum(split(text));
  }

  private static boolean checkEmptyOrNull(String text) {
    if (text == null || text.isEmpty()) {
      return true;
    }
    return false;
  }

  private static String[] split(String text) {
    return new TextSpliter(text).split();
  }

  private static int sum(String[] tokens) {
    return Arrays.stream(tokens).mapToInt(token -> {
      int number = Integer.parseInt(token);
      if (number < 0) {
        throw new RuntimeException("음수가 전달되었습니다.: " + number);
      }
      return number;
    }).sum();
  }
}

