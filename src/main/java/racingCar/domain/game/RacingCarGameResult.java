package racingCar.domain.game;

import java.util.List;
import racingCar.domain.car.RacingCar;

public class RacingCarGameResult {

  private final List<String> snapShots;

  private final List<RacingCar> winners;

  public RacingCarGameResult (List<RacingCar> winners, List<String> snapShots) {
    this.winners = winners;
    this.snapShots = snapShots;
  }

  public List<String> getSnapShots() {
    return snapShots;
  }

  public List<RacingCar> getWinners() {
    return winners;
  }
}
