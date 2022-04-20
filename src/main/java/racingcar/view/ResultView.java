package racingcar.view;

import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class ResultView {

  private static final String OUTPUT_FORMAT = "%s : %s";
  private static final String MOVING_SIGN = "-";
  private static final String WINNER_FORMAT = "%s가 최종 우승했습니다.";

  private ResultView() {
  }

  public static void printOutputStatement() {
    System.out.println("실행 결과");
  }

  public static void printOutput(Cars cars) {
    cars.getValues().forEach(car -> System.out.println(createOutput(car)));
    System.out.println();
  }

  public static void printWinners(Winners winners) {
    String winnerNames = winners.getValues().stream()
        .map(Car::getName)
        .collect(Collectors.joining(", "));
    System.out.printf(WINNER_FORMAT, winnerNames);
  }

  private static String createOutput(Car car) {
    return String.format(
        OUTPUT_FORMAT,
        car.getName(),
        MOVING_SIGN.repeat(car.getPosition())
    );
  }
}
