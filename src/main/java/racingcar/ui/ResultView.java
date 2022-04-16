package racingcar.ui;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;

public class ResultView {

  private static final String WINNER_FORMAT = "가 최종 우승했습니다.";

  private ResultView() {
  }

  public static void printOutputStatement() {
    System.out.println("실행 결과");
  }

  public static void printOutput(Cars cars) {
    cars.getValues().forEach(car -> System.out.println(car.toString()));
    System.out.println();
  }

  public static void printWinners(List<Car> winners) {
    String winnerNames = winners.stream()
        .map(Car::getName)
        .collect(Collectors.joining(", "));
    System.out.printf(winnerNames + WINNER_FORMAT);
  }
}
