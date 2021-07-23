package step3;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

  private static final String LOCATION_VIEW_SIGN = "-";
  private static final String NEWLINE = System.lineSeparator();
  public static final String DELIMITER = ", ";
  public static final String WINNER_LOG_SUFFIX = "가 최종 우승했습니다.";
  private final List<Car> cars;

  public Result(List<Car> cars) {
    this.cars = cars;
  }

  public String log() {
    return cars.stream()
        .map(car -> car.getName() + " : " + LOCATION_VIEW_SIGN.repeat(car.getLocation()))
        .collect(Collectors.joining(NEWLINE));
  }

  public String winnerLog() {
    final int maxLocation = cars.stream()
        .map(Car::getLocation)
        .max(Comparator.naturalOrder())
        .get();

    return cars.stream()
        .filter(car -> car.getLocation() >= maxLocation)
        .map(Car::getName)
        .collect(Collectors.joining(DELIMITER, "", WINNER_LOG_SUFFIX));

  }

}
