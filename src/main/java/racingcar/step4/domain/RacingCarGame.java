package racingcar.step4.domain;

import racingcar.step4.domain.strategy.RandomNumberGenerator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RacingCarGame {

  private final int round;
  private Cars racingCars;
  private Cars winners;

  private RacingCarGame(int round, Cars racingCars, Cars winners) {
    this.round = round;
    this.racingCars = racingCars;
    this.winners = winners;
  }

  public static RacingCarGame generate(int round, Cars cars) {
    return new RacingCarGame(round, cars, null);
  }

  // dto 컨버팅 용도
  public int getRound() {
    return round;
  }

  // dto 컨버팅 용도
  public List<Car> getRacingCars() {
    return racingCars.getCars();
  }

  // dto 컨버팅 용도
  public Cars getWinners() {
    return winners;
  }

  public static RacingCarGame findFinalGame(List<RacingCarGame> racingCarGames) {
    return Collections.max(racingCarGames, Comparator.comparing(it -> it.round));
  }

  public void start() {
    this.racingCars.move(new RandomNumberGenerator());
    this.racingCars = racingCars.copyCars();
    this.winners = racingCars.pickWinners();
  }
}
