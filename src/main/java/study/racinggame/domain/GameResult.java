package study.racinggame.domain;

import java.util.*;
import java.util.stream.Collectors;

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

  public List<String> winners() {
    return lastRecord().carNamesAtSameDistance(longestDistance());
  }

  private int longestDistance() {
    return lastRecord().cars().stream()
            .sorted()
            .collect(Collectors.toList())
            .get(0)
            .distance();
  }

  private Cars lastRecord() {
    return record.get(record.size() - 1);
  }
}
