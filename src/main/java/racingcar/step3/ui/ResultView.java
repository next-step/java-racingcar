package racingcar.step3.ui;

import racingcar.step3.dto.RacingCarGameResultDto;

import java.util.List;

public class ResultView {

  private static final String MOVE_MARK = "-";

  private ResultView() {
    throw new AssertionError();
  }

  public static void printResult(List<RacingCarGameResultDto> results) {
    System.out.println();
    System.out.println("실행 결과");

    results.forEach(it -> {
      System.out.println("[ROUND " + it.getRound() + "]");
      printRaceRecords(it.getRaceRecords());
    });
  }

  private static void printRaceRecords(List<RacingCarGameResultDto.RaceRecord> raceRecords) {
    raceRecords.forEach(raceRecord -> printRaceRecord(raceRecord.getCarName(), raceRecord.getCarPosition()));
    System.out.println();
  }

  private static void printRaceRecord(String carName, int moveCount) {
    String result = MOVE_MARK.repeat(Math.max(0, moveCount));
    System.out.println(carName + ": " + result);
  }
}
