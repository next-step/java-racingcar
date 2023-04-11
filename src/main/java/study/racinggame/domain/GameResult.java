package study.racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResult {
  private final List<Cars> record;

  public GameResult() {
    record = new ArrayList<>();
  }

  public List<Cars> record() {
    return Collections.unmodifiableList(record);
  }

  public void addRecord(Cars cars) {
    record.add(cars);
  }
}
