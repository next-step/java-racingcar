package racingcar.step3.domain;

import java.util.List;

public class RacingCarGameResult {

  private final int round;
  private final List<RaceRecord> raceRecords;

  public RacingCarGameResult(int round, List<RaceRecord> raceRecords) {
    this.round = round;
    this.raceRecords = raceRecords;
  }

  public int getRound() {
    return round;
  }

  public List<RaceRecord> getRaceRecords() {
    return raceRecords;
  }

  public static class RaceRecord {
    private final Car car;
    private final int moveCount;

    public RaceRecord(Car car, int moveCount) {
      this.car = car;
      this.moveCount = moveCount;
    }

    public Car getCar() {
      return car;
    }

    public int getMoveCount() {
      return moveCount;
    }
  }
}
