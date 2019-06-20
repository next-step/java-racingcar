package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Referee;

public class RacingGame {

  private Cars cars;

  public RacingGame(String[] carNames) {
    initCars(carNames);
  }

  private void initCars(String[] carNames) {
    cars = new Cars(carNames);
  }

  public List<Car> start() {
    return cars.moveCars();
  }

  public String announceWinners() {
    return Referee.announceWinners(cars);
  }
}
