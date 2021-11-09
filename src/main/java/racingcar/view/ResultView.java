package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class ResultView {

  private static final String CAR_POSITION_VALUE = "-";

  public static void printRacingResult(List<Car> cars) {
    cars.forEach(car -> {
      System.out.println(printCarPosition(car.getCurrentPosition()));
    });
    System.out.println();
  }

  private static String printCarPosition(int position) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < position; i++) {
      sb.append(CAR_POSITION_VALUE);
    }
    return sb.toString();
  }

}
