package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Winner {

  private final List<String> winners;

  private Winner(List<String> winners) {
    this.winners = winners;
  }

  public static Winner of(List<String> winners) {
    return new Winner(winners);
  }

  public List<String> getWinners() {
    return Collections.unmodifiableList(winners);
  }

  public String winnerListString() {
    return String.join(", ", winners);
  }
}
