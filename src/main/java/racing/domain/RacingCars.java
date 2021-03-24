package racing.domain;

import racing.rule.MoveRule;
import racing.utils.ListUtils;

import java.util.Collections;
import java.util.List;

public class RacingCars {

  private final List<RacingCar> racingCars;

  private RacingCars(List<RacingCar> racingCars) {
    this.racingCars = Collections.unmodifiableList(racingCars);
  }

  public static RacingCars create(List<RacingCar> racingCars) {
    return new RacingCars(racingCars);
  }

  public static RacingCars copyFrom(RacingCars racingCars) {
    return new RacingCars(ListUtils.deepCopy(racingCars.racingCars));
  }

  public void race(MoveRule moveRule) {
    for (RacingCar car : racingCars) {
      car.move(moveRule);
    }
  }

  public List<RacingCar> getRacingCars() {
    return this.racingCars;
  }
}
