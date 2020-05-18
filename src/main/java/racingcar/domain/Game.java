package racingcar.domain;

import java.util.List;

public class Game {

  List<Car> cars;

  private Game(List<Car> cars) {
    this.cars = cars;
  }

  public List<Car> getCars() {
    return cars;
  }

  public static Game create(List<Car> cars) {
    return new Game(cars);
  }
}
