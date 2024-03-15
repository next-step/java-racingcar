package racingcar.step4.domain;

import racingcar.step4.domain.strategy.RandomNumberGenerator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

  private final int round;
  private List<Car> cars;
  private Winners winners;

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

  public static RacingCarGame generate(int round, List<Car> cars) {
    return new RacingCarGame(round, cars, null);
  }

  public static RacingCarGame findFinalGame(List<RacingCarGame> racingCarGames) {
    return Collections.max(racingCarGames, Comparator.comparing(RacingCarGame::getRound));
  }

  public void start() {
    this.cars.forEach(it -> it.move(new RandomNumberGenerator()));
    List<Car> copyCars = cars.stream().map(Car::copy).collect(Collectors.toList());
    this.cars = copyCars;
    this.winners = Winners.pickWinners(copyCars);
  }
}
