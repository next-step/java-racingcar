package racingcar.ui;

import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winners;

public class ResultView {

  private static final String WINNER_FORMAT = "%s가 최종 우승했습니다.";

  private ResultView() {
  }

  public static void printOutputStatement() {
    System.out.println("실행 결과");
  }

  public static void printOutput(Cars cars) {
    cars.getValues().forEach(car -> System.out.println(car.toString()));
    System.out.println();
  }

  public static void printWinners(Winners winners) {
    String winnerNames = winners.getValues().stream()
        .map(Car::getName)
        .collect(Collectors.joining(", "));
    System.out.printf(WINNER_FORMAT, winnerNames);
  }
}
