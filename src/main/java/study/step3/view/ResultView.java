package study.step3.view;

import java.util.List;
import study.step3.domain.Car;

public class ResultView {

  private static final int START_RACE_NUM = 0;
  private static final String FOOTPRINT = "-";

  private ResultView() {
  }

  public static void printResult(int raceNum, List<Car> cars) {
    printRaceNum(raceNum);
    printCars(cars);
  }

  private static void printRaceNum(int raceNum) {
    if (isStartLine(raceNum)) {
      System.out.print("\n실행 결과");
    }
    System.out.println("\nRACE " + (raceNum + 1));
  }

  private static boolean isStartLine(int raceNum) {
    return raceNum == START_RACE_NUM;
  }

  private static void printCars(List<Car> cars) {
    for (Car car : cars) {
      System.out.println(FOOTPRINT.repeat(car.getDistance()));
    }
  }
}
