package racingcar.view;

import java.util.List;
import racingcar.controller.Movement;
import racingcar.model.Car;

public class ResultView {

  public static void showRacingResult(List<Car> cars) {
    cars.stream().map(car -> car.getName() + " : " + Movement.trackingMovement(car, "-"))
        .forEach(System.out::println);
    System.out.println();
  }
}
