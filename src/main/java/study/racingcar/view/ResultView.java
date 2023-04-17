package study.racingcar.view;

import java.util.List;
import study.racingcar.domain.Car;

public class ResultView {

  private static final int START_RACE_NUMBER = 0;
  private static final String DEFAULT_FOOTPRINT = "-";
  private static final String DEFAULT_DELIMITER = ",";
  private static final String NEXT_LINE = "\n";

  private ResultView() {
  }

  public static void printResult(int raceNumber, List<Car> cars) {
    printRaceNumber(raceNumber);
    printCars(cars);
  }

  private static void printRaceNumber(int raceNumber) {
    if (isStartLine(raceNumber)) {
      System.out.print(NEXT_LINE + "실행 결과");
    }
    System.out.println(NEXT_LINE + "RACE " + (raceNumber + 1));
  }

  private static boolean isStartLine(int raceNumber) {
    return raceNumber == START_RACE_NUMBER;
  }

  private static void printCars(List<Car> cars) {
    for (Car car : cars) {
      System.out.println(car.getName() + " : " + DEFAULT_FOOTPRINT.repeat(car.getDistance()));
    }
  }

  public static void printWinners(List<String> winners) {
    System.out.println(NEXT_LINE + String.join(DEFAULT_DELIMITER, winners) + "가 최종 우승했습니다.");
  }
}
