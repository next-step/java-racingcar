package racingcar;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Referee;
import racingcar.util.drivingStrategy.DrivingStrategy;

import java.util.List;

public class RacingGame {

  private Cars cars;

  public RacingGame(final String[] names) {
    this.cars = new Cars(names);
  }

  public RacingGame(final String[] names, final DrivingStrategy strategy) {
    this.cars = new Cars(names, strategy);
  }

  public List<Car> race() {
    return this.cars.move();
  }

  public String awards() {
    return Referee.getWinnerFrom(cars);
  }
}
