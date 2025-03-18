package racing.types;

import racing.simulator.RacingCarMovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGroup {

  private final List<RacingCar> racingCars = new ArrayList<>();
  RacingCarMovingStrategy racingCarMovingStrategy;

  public RacingCarGroup(List<RacingCarName> racingCarNames, RacingCarMovingStrategy racingCarMovingStrategy) {
    for (RacingCarName name: racingCarNames) {
      racingCars.add(new RacingCar(name));
    }
    this.racingCarMovingStrategy = racingCarMovingStrategy;
  }

  public RacingCarGroup(RacingCarCount racingCarCount, RacingCarMovingStrategy racingCarMovingStrategy) {
    for (int i = 0; i < racingCarCount.getCount(); i++) {
      racingCars.add(new RacingCar());
    }
    this.racingCarMovingStrategy = racingCarMovingStrategy;
  }

  public void moveCars() {
    racingCars.forEach(car -> car.go(racingCarMovingStrategy));
  }

  public List<RacingCar> copyCars() {
    List<RacingCar> res = new ArrayList<>();
    for (RacingCar racingCar : racingCars) {
      res.add(new RacingCar(racingCar));
    }
    return res;
  }

  public void resetCars() {
    for (RacingCar racingCar : racingCars) {
      racingCar.reset();
    }
  }
}
