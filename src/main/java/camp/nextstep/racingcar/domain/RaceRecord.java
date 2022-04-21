package camp.nextstep.racingcar.domain;

import java.util.List;

public class RaceRecord {

  private final int rounds;
  private final List<CarRecord> carRecords;

  public RaceRecord(int rounds, List<CarRecord> carRecords) {
    this.rounds = rounds;
    this.carRecords = carRecords;
  }

  public List<CarRecord> getCarRecords() {
    return carRecords;
  }

}
