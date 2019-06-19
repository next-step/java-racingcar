package racingcar;

import java.util.List;

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

  public String announceWinner() {
    return Referee.announceWinner(cars);
  }
}
