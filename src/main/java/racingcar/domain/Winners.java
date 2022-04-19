package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class Winners {

  private final List<Car> values;

  public Winners(List<Car> values) {
    this.values = values;
  }

  public List<Car> getValues() {
    return values;
  }

  public static Winners findWinners(Cars cars) {
    return new Winners(cars.findWinners());
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
