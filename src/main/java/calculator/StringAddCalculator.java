package calculator;

public class StringAddCalculator {

  public static final String DELIMITER = ",|:";

  public static int splitAndSum(String text) {
    String[] values = text.split(DELIMITER);
    return sum(toInts(values));
  }

  private static int[] toInts(String[] values) {
    int[] numbers = new int[values.length];
    for (int i = 0; i < values.length; i++) {
      numbers[i] = Integer.parseInt(values[i]);
    }
    return numbers;
  }

  private static int sum(int[] numbers) {
    int result = 0;
    for (int number : numbers) {
      result += number;
    }
    return result;
  }
}
