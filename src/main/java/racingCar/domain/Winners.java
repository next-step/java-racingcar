package racingCar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Winners {
  private final RacingCars winners;

  public Winners(RacingCars winners) {
    this.winners = winners;
  }

  public List<Name> findWinnersName() {
    return Collections.unmodifiableList(
        winners.getAllCars()
            .stream()
            .map(RacingCar::getName)
            .collect(Collectors.toList())
    );
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (getClass() != o.getClass()) {
      return false;
    }

    Winners winners1 = (Winners) o;
    return Objects.equals(winners.getAllCars(), winners1.winners.getAllCars());
  }

  @Override
  public int hashCode() {
    return Objects.hash(winners);
  }
}
