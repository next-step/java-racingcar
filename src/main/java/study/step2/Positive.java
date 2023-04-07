package study.step2;

public class Positive {
  public static int parseIntAndCheckPositive(String stringValue) {
    int number = Integer.parseInt(stringValue);
    checkPositive(number);
    return number;
  }

  private static void checkPositive(int number) {
    if (isMinus(number)) {
      throw new RuntimeException("음수는 입력할 수 없습니다.");
    }
  }

  private static boolean isMinus(int value) {
    return value < 0;
  }
}
