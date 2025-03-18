package racing.simulator;

import racing.types.RacingCarCount;
import racing.types.RacingCarName;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

  public List<Integer> getCarLocations() {
    return racingCars.stream().map(RacingCar::getLocation).collect(Collectors.toList());
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
