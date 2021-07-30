package step3;

import java.util.ArrayList;

public class ResultView {

  public static void printResultTitle() {
    System.out.println("\n실행 결과");
  }

  public static void printResult(ArrayList<Car> carList) {
    for (Car car : carList) {
      printCarLocation(car);
    }
  }

  private static void printCarLocation(Car car) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < car.getLocation(); i++) {
      sb.append("-");
    }
    System.out.println(sb);
  }
}
