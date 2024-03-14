package racingcar.step4.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

  private final int round;
  private final List<Car> cars;
  private final Winners winners;

  private RacingCarGame(int round, List<Car> cars, Winners winners) {
    this.round = round;
    this.cars = cars;
    this.winners = winners;
  }

  public int getRound() {
    return round;
  }

  public List<Car> getCars() {
    return cars;
  }

  public Winners getWinners() {
    return winners;
  }

  public static RacingCarGame start(int round, List<Car> cars) {
    cars.forEach(Car::move);
    return getRacingCarGameResult(round, cars);
  }

  public static RacingCarGame findFinalGame(List<RacingCarGame> racingCarGames) {
    return Collections.max(racingCarGames, Comparator.comparing(RacingCarGame::getRound));
  }

  private static RacingCarGame getRacingCarGameResult(int round, List<Car> cars) {
    List<Car> copyCars = cars.stream()
        .map(Car::copy)
        .collect(Collectors.toList());
    return new RacingCarGame(round, copyCars, Winners.pickWinners(copyCars));
  }
}
