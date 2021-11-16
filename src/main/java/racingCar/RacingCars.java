package racingCar;

import java.util.List;
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

  public List<Integer> getAllCarsMoveCount() {
    return racingCars.stream()
        .map(RacingCar::getMoveCount)
        .collect(Collectors.toList());
  }
}
