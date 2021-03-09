package racingCar;

public class OutputView {

  private static final String CAR_QUESTION = "자동차 대수는 몇 대 인가요?";
  private static final String TRY_QUESTION = "시도할 회수는 몇 회 인가요?";
  private static final String RESULT = "실행결과";
  private static final String HYPHEN = "-";

  public static void printCarNumber() {
    System.out.println(CAR_QUESTION);
  }

  public static void printTryCount() {
    System.out.println(TRY_QUESTION);
  }

  public static void printResult() {
    System.out.println(RESULT);
  }

  public static void printCarDistance(int distance) {
    for (int i = 0; i < distance; i++) {
      System.out.print(HYPHEN);
    }
    System.out.println();
  }

  public static void printEmptyLine() {
    System.out.println();
  }

}
