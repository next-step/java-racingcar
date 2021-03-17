package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingRound {

  private List<RacingCar> racingCars;

  private RacingRound() {
  }

  public RacingRound(List<RacingCar> racingCars) {
    this.racingCars = racingCars;
  }

  public static RacingRound newRecord(List<RacingCar> racingCars) {
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
    racingCars().add(RacingCar.copyCar(racingCar));
  }

  public List<RacingCar> racingCars() {
    if (this.racingCars == null) {
      this.racingCars = new ArrayList<>();
    }
    return this.racingCars;
  }
}
