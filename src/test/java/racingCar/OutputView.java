package racingCar;

public class OutputView {
  public static void printCarNumber() {
    System.out.println("자동차 대수는 몇 대 인가요?");
  }

  public static void printTryCount() {
    System.out.println("시도할 회수는 몇 회 인가요?");
  }

  public static void printResult() {
    System.out.println("실행 결과");
  }

  public static void printCarDistance(int distance) {
    for (int i=0 ; i < distance ; i++) {
      System.out.print("-");
    }
    System.out.println();
  }

  public static void printEmptyLine() {
    System.out.println();
  }

}
