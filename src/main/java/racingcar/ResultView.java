package racingcar;


import java.util.List;

public class ResultView {
  public static void printCurrentStatus(final Cars cars) {
    for (Car car : cars.getCars()) {
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

  public static void printWinners(List<Car> winners) {
    StringBuilder resultMessage = new StringBuilder();
    final String CONNECTOR_TEXT = ", ";

    for (Car car : winners) {
      resultMessage.append(car.name()).append(CONNECTOR_TEXT);
    }

    final int MESSAGE_START = 0;
    System.out.println(resultMessage.substring(MESSAGE_START, resultMessage.length() - CONNECTOR_TEXT.length()).concat("가 최종 우승했습니다."));
  }
}
