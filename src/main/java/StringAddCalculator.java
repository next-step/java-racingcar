public class StringAddCalculator {

  private StringAddCalculator() {
  }

  public static int splitAndSum(String text) {
    /*
    1. String을 int의 배열로 split한다.
    2. int의 배열을 순회하면서 더한다.
    3. 결과값을 반환한다.
     */
    if (isBlank(text)) {
      return 0;
    }

    return StringNumbers.from(text)
        .sum();
  }

  private static boolean isBlank(String text) {
    return text == null || text.isBlank();
  }
}
