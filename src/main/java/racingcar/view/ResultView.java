package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.Movement;
import racingcar.controller.Winner;
import racingcar.model.Car;

public class ResultView {

  public static void showRacingResult(List<Car> cars) {
    cars.stream().map(car -> car.getName() + " : " + Movement.trackingMovement(car, "-"))
        .forEach(System.out::println);
    System.out.println();
  }

  public static void showWinnerName(List<Car> cars) {
    Winner win = new Winner();

    System.out.println(
        win.getWinner(cars).stream().map(Car::getName).collect(Collectors.joining(", "))
            + "가 최종 우승했습니다.");

  }
}
