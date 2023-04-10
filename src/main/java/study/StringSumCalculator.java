package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {

  static String DELIMITER = ",|:";

  public static int sum(String text) {
    if (text == null || text.isEmpty()) {
      return 0;
    }

    String delimiter = DELIMITER;
    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
    if (m.find()) {
      delimiter = m.group(1);
      text = m.group(2);
    }

    return sum(toInts(split(text, delimiter)));
  }

  private static int[] toInts(String[] tokens) {
    int[] numbers = new int[tokens.length];
    for (int i = 0; i < tokens.length; i++) {
      int num = checkNegative(toInt(tokens[i]));
      numbers[i] = num;
    }
    return numbers;
  }

  private static String[] split(String text, String delimiter) {
    return text.split(delimiter);
  }

  private static int sum(int[] numbers) {
    int sum = 0;
    for (int number : numbers) {
      sum += number;
    }
    return sum;
  }

  private static int checkNegative(int number) {
    if (number < 0) {
      throw new RuntimeException("양수만 입력할 수 있습니다.");
    }
    return number;
  }

  private static int toInt(String token) {
    try {
      return Integer.parseInt(token);
    } catch (Exception e) {
      throw new RuntimeException("양수만 입력할 수 있습니다.");
    }
  }

}
