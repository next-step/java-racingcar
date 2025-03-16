package racing.util;

import racing.simulator.Car;

import java.util.List;

public class OutputView {

  public static void showExecutionResultText() {
    System.out.println("실행 결과");
  }

  public static void showCarsLocation(List<Car> cars) {
    cars.forEach(OutputView::showCarLocation);
  }

  public static void showCarLocation(Car car) {
    System.out.println("-".repeat(Math.max(0, car.getLocation())));
  }

  public static void showWhitespace() {
    System.out.println();
  }
}
