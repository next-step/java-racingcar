package racingCar;

public class OutputView {

  private static final String RESULT = "실행결과";
  private static final String HYPHEN = "-";

  public void printResult() {
    System.out.println(RESULT);
  }

  public void printCarDistance(int distance) {
    for (int i = 0; i < distance; i++) {
      System.out.print(HYPHEN);
    }
    printEmptyLine();
  }

  public void printEmptyLine() {
    System.out.println();
  }

}
