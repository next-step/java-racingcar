package racingcar.view;

import java.util.List;
import racingcar.Movement;
import racingcar.model.Car;

public class ResultView {

  public static void showRacingResult(List<Car> cars) {
    cars.forEach(car -> {
      System.out.println(Movement.trackingMovement(car, "-"));
    });
  }
}
