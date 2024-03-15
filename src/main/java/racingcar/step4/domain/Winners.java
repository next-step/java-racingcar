package racingcar.step4.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Winners {

  private final List<Car> winners;

  private Winners(List<Car> winners) {
    this.winners = winners;
  }

  public static Winners pickWinners(List<Car> candidates) {
    Car winnerCandidate = Collections.max(candidates);
    List<Car> winner = candidates.stream()
        .filter(car -> Objects.equals(car.getPosition().get(), winnerCandidate.getPosition().get()))
        .collect(Collectors.toList());

    return new Winners(winner);
  }

  public List<String> getWinnerNames() {
    return winners.stream()
        .map(it -> it.getCarName().get())
        .collect(Collectors.toList());
  }
}
