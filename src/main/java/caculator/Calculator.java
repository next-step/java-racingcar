package caculator;

public class Calculator {

  public static int calculate(String text) {
    if (isBlank(text)) {
      return  0;
    }

    return sum(toInts(split(text)));
  }

  private static boolean isBlank(String text) {
    return text == null || text.isBlank();
  }

  private static String[] split(String text) {
    if (text.startsWith("//")) {
      String delimiter = text.substring(2, 3);
      return customSplit(text.substring(4), delimiter);
    }
    return text.split(",|:");
  }

  private static String[] customSplit(String text, String delimiter) {
    return text.split(delimiter);
  }

  private static int sum(int[] values) {
    int result = 0;
    for (int value : values) {
      if (isNegative(value)) {
        throw new RuntimeException("please set number greater than 0");
      }
      result += value;
    }
    return result;
  }

  private static int[] toInts(String[] values) {
    int[] numbers = new int[values.length];
    for (int i = 0; i < values.length; i++) {
      numbers[i] = Integer.parseInt(values[i]);
    }
    return numbers;
  }

  private static boolean isNegative(int number) {
    return number < 0;
  }
}
