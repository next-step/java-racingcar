package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingWinnerDeterminer {
  public static List<String> getWinner(List<Car> records) {
    int maxPosition = getMaxPosition(records);
    return records.stream()
        .filter(car -> car.getPosition() == maxPosition)
        .map(Car::getName)
        .collect(Collectors.toList());
  }

  private static int getMaxPosition(List<Car> records) {
    return records.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(0);
  }
}
