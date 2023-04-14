package study.racinggame.view;

import study.racinggame.domain.Car;
import study.racinggame.domain.Cars;
import study.racinggame.domain.GameResult;

import java.util.List;

public class ResultView {

  private static final String PRINTED_DISTANCE = "-";
  private static final String RESULT_TITLE = "실행 결과";
  private static final String WINNER_DELIMITER = ", ";
  private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
  private static final String NAME_DISTANCE_DELIMITER = " : ";

  private ResultView() {}

  public static void show(GameResult result) {
    System.out.println();
    System.out.println(RESULT_TITLE);

    for (Cars cars : result.record()) {
     printDistance(cars);

     System.out.println();
    }

    printWinners(result.winners());
  }

  private static void printWinners(List<String> winners) {
    System.out.println(String.join(WINNER_DELIMITER, winners) + WINNER_MESSAGE);
  }

  private static void printDistance(Cars cars) {
    cars.cars().forEach((car) -> System.out.println(car.name() + NAME_DISTANCE_DELIMITER + PRINTED_DISTANCE.repeat(car.distance())));
  }
}
