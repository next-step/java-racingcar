package study.step2;

public class StringAddCalculator {

  public static int splitAndSum(String value) {
    if (isNullOrEmpty(value)) {
      return 0;
    }

    String[] numbers = DelimiterManager.split(value);

    return sum(numbers);
  }

  private static boolean isNullOrEmpty(String value) {
    return value == null || value.isEmpty();
  }

  private static int sum(String[] numbers) {
    int sum = 0;
    for (String number : numbers) {
      sum += Positive.parseIntAndCheckPositive(number);
    }
    return sum;
  }
}