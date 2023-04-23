package study.racingcar.view;

import java.util.ArrayList;
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
      System.out.println(car.getName() + " : " + car.getFootPrint(DEFAULT_FOOTPRINT));
    }
  }

  public static void printWinners(List<Car> winners) {
    System.out
        .println(NEXT_LINE + String.join(DEFAULT_DELIMITER, getNames(winners)) + "가 최종 우승했습니다.");
  }

  private static List<String> getNames(List<Car> winners) {
    List<String> names = new ArrayList<>();
    for (Car winner : winners) {
      names.add(winner.getName());
    }
    return names;
  }
}
