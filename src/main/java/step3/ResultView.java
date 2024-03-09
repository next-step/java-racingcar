package step3;


public class ResultView {
  public static void printCurrentStatus(final CarRepository carRepository) {
    for (Car car : carRepository.getCars()) {
      printCarDistance(car);
    }
    printRepSeparator();
  }

  private static void printCarDistance(final Car car) {
    System.out.println(createDistanceGraphic(car));
  }

  private static String createDistanceGraphic(final Car car) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < car.getLocation(); i++) {
      sb.append('-');
    }
    return sb.toString();
  }

  public static void printExecutionComment() {
    System.out.println("실행 결과");
  }

  private static void printRepSeparator() {
    System.out.println();
  }
}
