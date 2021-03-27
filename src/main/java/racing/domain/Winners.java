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
            .filter(car -> car.isWinner(winnerPosition(racingCars)))
            .collect(Collectors.toList());
  }

  private static Position winnerPosition(RacingCars racingCars) {
    return racingCars.getRacingCars().stream()
            .map(RacingCar::position)
            .max(Position::compareTo)
            .orElse(Position.Zero());
  }

  public List<Name> winnerNames() {
    return winners.stream()
            .map(RacingCar::name)
            .collect(Collectors.toList());
  }

  public List<RacingCar> getList() {
    return winners;
  }

}
