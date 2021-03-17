package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingRound {

  private List<RacingCar> racingCars;

  private RacingRound() {
  }

  public static RacingRound createRecord(List<RacingCar> racingCars) {
    RacingRound round = new RacingRound();
    round.record(racingCars);
    return round;
  }

  private void record(List<RacingCar> racingCars) {
    for (RacingCar car : racingCars) {
      capture(car);
    }
  }

  private void capture(RacingCar racingCar) {
    getRacingCars().add(RacingCar.copy(racingCar));
  }

  public List<RacingCar> getRacingCars() {
    if (this.racingCars == null) {
      this.racingCars = new ArrayList<>();
    }
    return this.racingCars;
  }
}
