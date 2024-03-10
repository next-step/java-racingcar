package step3;


public class ResultView {
  public static void printCurrentStatus(final CarRepository carRepository) {
    for (Car car : carRepository.getCars()) {
      printCarDistance(car);
    }
    printRepSeparator();
  }

  private static void printCarDistance(final Car car) {
    System.out.println(car.trace());
  }

  public static void printExecutionComment() {
    System.out.println("실행 결과");
  }

  private static void printRepSeparator() {
    System.out.println();
  }
}
