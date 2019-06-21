package racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Winners {

  private List<Car> winners;

  public Winners(List<Car> winners) {
    this.winners = winners;
  }

  public List<String> getNames() {
    return winners.stream()
        .map(Car::getName)
        .collect(Collectors.toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Winners winners1 = (Winners) o;
    return Objects.equals(winners, winners1.winners);
  }

  @Override
  public int hashCode() {
    return Objects.hash(winners);
  }
}
