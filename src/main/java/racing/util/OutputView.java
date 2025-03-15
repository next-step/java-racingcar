package racing.util;

import racing.simulator.Car;

public class OutputView {

  public static void showExecutionResultText() {
    System.out.println("실행 결과");
  }

  public static void showCarLocation(Car[] cars) {
    for (Car car: cars) {
      System.out.println(car.getLocationConsoleFormat());
    }
  }

  public static void showWhitespace() {
    System.out.println();
  }
}
