package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {

  public static final String DELIMITER = ", ";
  private final List<CarName> winners;

  private Winner(List<CarName> winners) {
    this.winners = winners;
  }

  public static Winner of(List<CarName> winners) {
    return new Winner(winners);
  }

  public List<CarName> getWinners() {
    return Collections.unmodifiableList(winners);
  }

  public String winnerListString() {
    return winners.stream().map(CarName::getName).collect(Collectors.joining(DELIMITER));
  }
}
