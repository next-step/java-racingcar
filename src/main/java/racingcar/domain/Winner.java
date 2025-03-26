package racingcar.domain;

import java.util.List;

public class Winner {

  private final Cars result;

  public Winner(Result result) {
    this.result = result.getFinalRound();
  }

  public List<Car> getWinners() {
    return result.findWinners();
  }
}
