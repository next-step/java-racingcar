package study.racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResult {

  private static final int LAST_ELEMENT = 1;
  private final List<Cars> record;

  public GameResult() {
    record = new ArrayList<>();
  }

  public GameResult(Cars cars) {
    record = new ArrayList<>(List.of(cars));
  }

  public List<Cars> record() {
    return Collections.unmodifiableList(record);
  }

  public void addRecord(Cars cars) {
    record.add(cars);
  }

  public List<String> winners() {
    return lastRecord().carNamesAtLongestDistance();
  }

  private Cars lastRecord() {
    return record.get(record.size() - LAST_ELEMENT);
  }
}
