package racingcar.step3.ui;

import racingcar.step3.domain.Car;
import racingcar.step3.domain.RacingCarGameResult;

import java.util.List;

public class ResultView {

  private static final String MOVE_MARK = "-";

  private ResultView() {
    throw new AssertionError();
  }

  public static void printResult(List<RacingCarGameResult> results) {
    System.out.println();
    System.out.println("실행 결과");

    results.forEach(it -> {
      System.out.println("[ROUND " + it.getRound() + "]");
      printRaceRecords(it.getRaceRecords());
    });
  }

  private static void printRaceRecords(List<RacingCarGameResult.RaceRecord> raceRecords) {
    raceRecords.forEach(raceRecord -> printRaceRecord(raceRecord.getCar(), raceRecord.getMoveCount()));
    System.out.println();
  }

  private static void printRaceRecord(Car car, int moveCount) {
    String result = MOVE_MARK.repeat(Math.max(0, moveCount));
    System.out.println(car.getCarName() + ": " + result);
  }
}
