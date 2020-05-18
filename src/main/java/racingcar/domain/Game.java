package racingcar.domain;

import java.util.List;

public class Game {

  private List<Car> cars;

  private Game(List<Car> cars) {
    this.cars = cars;
  }

  public void doRace(int random) {
    this.cars.forEach(element -> element.updatePosition(random));
  }

  public List<Car> getCars() {
    return cars;
  }

  public static Game create(List<Car> cars) {
    return new Game(cars);
  }
}
