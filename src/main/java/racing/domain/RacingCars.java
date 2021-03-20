package racing.domain;

import racing.rule.MoveRule;
import racing.utils.ListUtils;

import java.util.ArrayList;
import java.util.Collections;
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
    this.racingCars = Collections.unmodifiableList(racingCars);
  }

  public static RacingCars create(String... playerNames) {
    List<RacingCar> racingCars = new ArrayList<>();
    for (String name : playerNames) {
      racingCars.add(RacingCar.create(name));
    }
    return new RacingCars(racingCars);
  }

  public static RacingCars create(int totalPlayer) {
    return new RacingCars(totalPlayer);
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
