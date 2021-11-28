package racingCar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

  private final List<RacingCar> racingCars;

  public RacingCars(List<RacingCar> racingCars) {
    this.racingCars = racingCars;
  }

  public void moveAllCars() {
    racingCars.forEach(e -> e.tryMove(MyNumber.generateRandomNumber()));
  }

  public Winners findWinners() {
    List<RacingCar> winners = racingCars.stream()
            .filter(racingCar -> racingCar.getPosition().equals(findWinnerPosition()))
            .collect(Collectors.toList());

    return new Winners(new RacingCars(winners));
  }

  private Position findWinnerPosition() {
    return Collections.max(racingCars).getPosition();
  }

  public List<RacingCar> getAllCars() {
    return Collections.unmodifiableList(racingCars);
  }
}
