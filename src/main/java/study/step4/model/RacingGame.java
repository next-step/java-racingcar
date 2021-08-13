package study.step4.model;

import study.step4.model.car.Cars;
import study.step4.model.strategy.MoveStrategy;

public class RacingGame {

  private final Cars cars;

  private final int racingGameRound;

  public RacingGame(int carNumber, int gameRound) {
    cars = Cars.of(carNumber);
    racingGameRound = gameRound;
  }

  public RacingGame(String carNames, int gameRound) {
    cars = Cars.of(carNames);
    racingGameRound = gameRound;
  }

  public void start(MoveStrategy moveStrategy) {
      cars.move(moveStrategy);
  }

  public Cars getCars() {
    return cars;
  }

  public int getRacingGameRound() {
    return racingGameRound;
  }
}
