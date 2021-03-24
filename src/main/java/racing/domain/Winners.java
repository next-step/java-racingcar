package racing.domain;

import racing.utils.ListUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

  private List<RacingCar> winners;

  private Winners(List<RacingCar> winners) {
    this.winners = Collections.unmodifiableList(ListUtils.deepCopy(winners));
  }

  public static Winners create(RacingCars racingCars) {
    return new Winners(findWinners(racingCars));
  }

  private static List<RacingCar> findWinners(RacingCars racingCars) {
    return racingCars.getRacingCars().stream()
            .filter(car -> winnerPosition(racingCars) == car.position())
            .collect(Collectors.toList());
  }

  private static int winnerPosition(RacingCars racingCars) {
    return racingCars.getRacingCars().stream()
            .map(RacingCar::position)
            .max(Integer::compareTo)
            .orElse(0)
            .intValue();
  }

  public List<RacingCar> getList() {
    return winners;
  }

}
