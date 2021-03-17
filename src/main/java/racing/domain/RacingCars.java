package racing.domain;

import racing.rule.MoveRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCars {

  private final List<RacingCar> racingCars;

  private RacingCars(int totalPlayer) {
    this(IntStream.range(0, totalPlayer)
            .mapToObj(RacingCar::create)
            .collect(Collectors.toList()));
  }

  private RacingCars(List<RacingCar> racingCars) {
    this.racingCars = racingCars;
  }

  public static RacingCars create(int totalPlayer) {
    return new RacingCars(totalPlayer);
  }

  public static RacingCars copyFrom(RacingCars racingCars) {
    List<RacingCar> result = new ArrayList<>();
    for (RacingCar car : racingCars.getRacingCars()) {
      result.add(RacingCar.copyFrom(car));
    }
    return new RacingCars(result);
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
