package racingcar.ui;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class ResultView {

  public static final String DASH = "-";
  public static final String EXECUTE_RESULT = "실행 결과";

  public static void printExecuteMessage() {
    System.out.println(EXECUTE_RESULT);
  }

  public static void print(Cars cars) {
    for (Car car : cars.getCars()) {
      System.out.println(car.getName() + " : " + convertPositionToDash(car.getPosition()));
    }
    System.out.println();
  }

  private static String convertPositionToDash(int position) {
    return DASH.repeat(Math.max(0, position));
  }

  public static void printWinnersName(Cars cars) {
    String winnersName = String.join(",", cars.getWinnersName());
    System.out.println(winnersName + "가 최종 우승했습니다.");
  }
}
