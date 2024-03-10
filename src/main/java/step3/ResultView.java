package step3;


public class ResultView {
  public static void printCurrentStatus(final CarRepository carRepository) {
    for (Car car : carRepository.getCars()) {
      printResultLine(car);
    }
    printRepSeparator();
  }

  private static void printResultLine(final Car car) {
    final String DISTANCE_UNIT = "-";
    System.out.printf("%s : %s\r\n", car.name(), car.trace(DISTANCE_UNIT));
  }

  public static void printExecutionComment() {
    System.out.println("실행 결과");
  }

  private static void printRepSeparator() {
    System.out.println();
  }
}
