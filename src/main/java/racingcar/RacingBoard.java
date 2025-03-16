package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingBoard {
  private final int round;
  private List<Integer> records; // 자동차 위치 저장

  public RacingBoard(int round) {
    this.round = round;
    this.records = new ArrayList<>();
  }

  public int getRound() {
    return round;
  }

  public void record(int position) {
    records.add(position);
  }

  public List<Integer> getRecords() {
    return records;
  }
}
