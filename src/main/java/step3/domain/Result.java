package step3.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

  private final List<Car> cars;

  public Result(List<Car> cars) {
    this.cars = cars;
  }

  public List<String> getWinners() {
    final int maxLocation = getMaxLocation();

    return cars.stream()
        .filter(car -> car.getLocation() >= maxLocation)
        .map(Car::getName)
        .collect(Collectors.toList());
  }

  private Integer getMaxLocation() {
    return cars.stream()
        .map(Car::getLocation)
        .max(Comparator.naturalOrder())
        .get();
  }

  public List<Car> getCars() {
    return cars;
  }
}
