package study.racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
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

  public String winners() {
    return lastRecord().cars().stream()
            .filter(v -> v.isEqualToDistance(longestDistance()))
            .map(Car::name)
            .collect(Collectors.joining(","));
  }

  private int longestDistance() {
    return lastRecord().cars().stream()
            .mapToInt(Car::distance)
            .max()
            .orElse(Car.DEFAULT_DISTANCE);
  }

  private Cars lastRecord() {
    return record.get(record.size() - 1);
  }
}
