package racingCar.model;

import java.util.Collections;
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

  public RacingCars determineWinners() {
    List<RacingCar> winners = racingCars.stream()
        .filter(racingCar -> racingCar.getPosition().equals(Collections.max(racingCars).getPosition()))
        .collect(Collectors.toList());
    return new RacingCars(winners);
  }

  public List<RacingCar> getAllCars() {
    return Collections.unmodifiableList(racingCars);
  }
}
