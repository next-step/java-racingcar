package racingCar;

public class OutputView {

  private static final String RESULT = "실행결과";
  private static final String HYPHEN = "-";
  private static final String COLON = " : ";

  public void printResult() {
    System.out.println(RESULT);
  }

  public void printCarDistance(Car car) {
    System.out.print(car.getName() + COLON);
    for (int i = 0; i < car.getDistance(); i++) {
      System.out.print(HYPHEN);
    }
    printEmptyLine();
  }

  public void printEmptyLine() {
    System.out.println();
  }

}
