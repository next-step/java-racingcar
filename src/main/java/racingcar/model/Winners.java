package racingcar.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Winners {

  private final List<Car> values;

  public Winners(List<Car> values) {
    this.values = values;
  }

  public List<Car> getValues() {
    return values;
  }

  public static Winners findWinners(Cars cars) {
    Car winnerCar = cars.getValues().stream()
        .max(Car::compareTo)
        .orElseThrow(IllegalStateException::new);
    List<Car> winners = cars.getValues().stream()
        .filter(car -> car.hasSamePosition(winnerCar))
        .collect(Collectors.toList());
    return new Winners(winners);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Winners winners = (Winners) o;
    return Objects.equals(values, winners.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }
}
