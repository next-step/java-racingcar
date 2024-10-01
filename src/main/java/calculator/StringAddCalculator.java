package calculator;

public class StringAddCalculator {

  public static int splitAndSum(String number) {
    if (number.contains(",")) {
      return sum(toInts(number.split(",")));
    }
    return Integer.parseInt(number);
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
