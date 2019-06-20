package racingcar;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Referee;

import java.util.List;

public class RacingGame {

  private Cars cars;

  public RacingGame(final String[] names) {
    this.cars = new Cars(names);
  }

  public List<Car> race() {
    return this.cars.move();
  }

  public String awards() {
    return Referee.getWinnerFrom(cars);
  }
}
