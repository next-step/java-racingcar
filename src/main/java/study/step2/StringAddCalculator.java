package study.step2;


public class StringAddCalculator {

  private static final int ZERO = 0;

  public static int splitAndSum(String text) {
    if (isNullOrEmpty(text)) {
      return ZERO;
    }

    return sum(toNumbers(split(text)));
  }

  private static boolean isNullOrEmpty(String text) {
    return text == null || text.isEmpty();
  }

  private static String[] split(String text) {
    return TextSpliter.split(text);
  }

  private static int[] toNumbers(String[] values) {
    int[] numbers = new int[values.length];
    for (int i = 0; i < values.length; i++) {
      int number = toNumber(values[i]);
      numbers[i] = number;
    }
    return numbers;
  }

  private static int toNumber(String value) {
    int number = Integer.parseInt(value);
    if (number < 0) {
      throw new RuntimeException("음수가 전달되었습니다.: " + number);
    }
    return number;
  }

  private static int sum(int[] numbers) {
    int sum = 0;
    for (int number : numbers) {
      sum += number;
    }
    return sum;
  }
}
