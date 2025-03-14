package calculator;

public class StringCalculator {

  public static int calculate(String textNumbers) {
    if (isBlank(textNumbers)) {
      return 0;
    }
    return Integer.parseInt(textNumbers);
  }

  private static boolean isBlank(String text) {
    return text == null || text.isEmpty();
  }
}
