package racingcar.step3.dto;

import java.util.List;

public class RacingCarGameResultDto {

  private final int round;
  private final List<RaceRecord> raceRecords;

  public RacingCarGameResultDto(int round, List<RaceRecord> raceRecords) {
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
    private final String carName;
    private final int carPosition;

    public RaceRecord(String carName, int carPosition) {
      this.carName = carName;
      this.carPosition = carPosition;
    }

    public String getCarName() {
      return carName;
    }

    public int getCarPosition() {
      return carPosition;
    }
  }
}
