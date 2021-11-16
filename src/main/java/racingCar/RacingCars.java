package racingCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingCars {

  private final List<RacingCar> racingCars;

  public RacingCars(List<RacingCar> racingCars) {
    this.racingCars = racingCars;
  }

  public void add(RacingCar racingCar) {
    racingCars.add(racingCar);
  }

  public void moveAllCars() {
    racingCars.forEach(e -> e.tryMove(new Random().nextInt(10)));
  }

  public List<String> getWinnerNames() {
    RacingCar maxMovedCar = Collections.max(racingCars);
    return racingCars.stream()
        .filter(winner -> maxMovedCar.getMoveCount() == winner.getMoveCount())
        .map(RacingCar::getName)
        .collect(Collectors.toList());
  }

  public List<RacingCar> getAllCars() {
    return racingCars;
  }
}
